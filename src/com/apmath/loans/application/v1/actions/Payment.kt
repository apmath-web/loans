package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.BadRequestException
import com.apmath.loans.application.v1.exceptions.BadRequestValidationException
import com.apmath.loans.application.v1.exceptions.NotFoundException
import com.apmath.loans.application.v1.models.incoming.Payment
import com.apmath.loans.application.v1.models.incoming.toPaymentDomain
import com.apmath.loans.application.v1.validators.PaymentBuilder
import com.apmath.loans.domain.exceptions.LoanCompletedException
import com.apmath.loans.domain.exceptions.LoanNotFoundException
import com.apmath.loans.domain.exceptions.ForeignClientIdException
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.client.features.BadResponseStatusException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

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

        } catch (e: LoanCompletedException) {
            throw BadRequestException("Loan already paid")

        } catch (e: ForeignClientIdException) {
            throw BadRequestException("Wrong client ID")

        } catch (e: LoanNotFoundException) {
            throw BadRequestException("Loan not found loan")

        } catch (e: BadResponseStatusException) {
            when(e.statusCode) {
                HttpStatusCode.BadRequest   -> throw BadRequestException(e.localizedMessage)
                HttpStatusCode.NotFound     -> throw NotFoundException(e.localizedMessage)
                else                        -> throw e
            }
        }

    respond(mapOf("paymentExecutedAt" to date))
}
