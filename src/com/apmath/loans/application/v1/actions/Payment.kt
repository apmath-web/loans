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
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.client.features.BadResponseStatusException
import io.ktor.request.receive
import io.ktor.response.respond

suspend fun ApplicationCall.v1Payment(paymentService: PaymentServiceInterface, loanId: String) {
    val payment = receive<Payment>()
    payment.clientId = getUserId(request)
    payment.loanId = loanId

    val validator = PaymentBuilder()
        .prepend("payment", RequiredValidator())
        .prepend("currency", RequiredValidator())
        .prepend("date", NullableValidator())
        .prepend("clientId", NullableValidator())
        .prepend("loanId", RequiredValidator())
        .build()

    if (!validator.validate(payment)) {
        throw BadRequestValidationException(validator)
    }

    val paymentDomain = payment.toPaymentDomain()

    val date =
        try {

            paymentService.add(paymentDomain)

        } catch (e: AlreadyPayException) {
            throw BadRequestException("Loan already payed")

        } catch (e: WrongClientId) {
            throw BadRequestException("Wrong client")

        } catch (e:BadResponseStatusException) {

            when{
                e.statusCode.value == 400
                -> throw BadRequestException(" Bad time")

                e.statusCode.value == 404
                -> throw BadRequestException("Not found")
            }
            return
        }

    respond(mapOf("paymentExecutedAt" to date))
}
