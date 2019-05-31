package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.BadRequestException
import com.apmath.loans.application.v1.exceptions.BadRequestValidationException
import com.apmath.loans.application.v1.exceptions.ForbiddenException
import com.apmath.loans.application.v1.exceptions.NotFoundException
import com.apmath.loans.application.v1.models.incoming.Payment
import com.apmath.loans.application.v1.models.incoming.toPaymentDomain
import com.apmath.loans.application.v1.validators.PaymentBuilder
import com.apmath.loans.domain.exceptions.AlreadyPayException
import com.apmath.loans.domain.exceptions.ForbiddenAccessException
import com.apmath.loans.domain.exceptions.NoClientException
import com.apmath.loans.domain.exceptions.WrongClientId
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.Message
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.client.features.BadResponseStatusException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import kotlinx.coroutines.io.readUTF8Line

suspend fun ApplicationCall.v1Payment(
    paymentService: PaymentServiceInterface,
    loanIdKey: String,
    clientIdParam: String?
) {
    val payment = receive<Payment>()
    payment.loanId = loanIdKey

    val clientId = getAndValidateClientId(clientIdParam)

    val loanId = getAndValidateLoanId(loanIdKey)

    val validator = PaymentBuilder()
        .prepend("payment", RequiredValidator())
        .prepend("currency", RequiredValidator())
        .prepend("date", NullableValidator())
        .prepend("loanId", RequiredValidator())
        .build()

    if (!validator.validate(payment)) {
        throw BadRequestValidationException(validator)
    }

    val paymentDomain = payment.toPaymentDomain()

    val date =
        try {

            paymentService.add(paymentDomain, loanId, clientId)

        } catch (e: AlreadyPayException) {
            throw BadRequestException("Loan already payed")

        } catch (e: WrongClientId) {
            throw BadRequestException("Wrong client")

        } catch (e:BadResponseStatusException) {
            println(e.response.content.readUTF8Line())
            respond(e.response.content.readUTF8Line()!!)
            when(e.statusCode){
                HttpStatusCode.BadRequest   -> throw BadRequestException(e.localizedMessage)
                HttpStatusCode.NotFound     -> throw NotFoundException(e.localizedMessage)
                else                        -> throw e
            }
        }

    respond(mapOf("paymentExecutedAt" to date))
}
