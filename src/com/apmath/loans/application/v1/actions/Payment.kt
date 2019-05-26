package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.BadRequestValidationException
import com.apmath.loans.application.v1.models.incoming.Payment
import com.apmath.loans.application.v1.models.incoming.toPaymentDomain
import com.apmath.loans.application.v1.validators.PaymentBuilder
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
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

    val loanId = payment.loanId!!.toInt()
    val clientId = payment.clientId!!

    val date =
        try {
            paymentService.add(paymentDomain, loanId, clientId)
        } catch (e: Exception) {

            //TODO add Exceptions handler
            return
        }

    respond(mapOf("paymentExecutedAt" to date))
}
