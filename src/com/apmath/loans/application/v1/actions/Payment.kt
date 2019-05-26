package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.BadRequestValidationException
import com.apmath.loans.application.v1.models.incoming.Payment
import com.apmath.loans.application.v1.models.incoming.toPaymentDomain
import com.apmath.loans.application.v1.validators.PaymentBuilder
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.Message
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.request.receive
import io.ktor.response.respond

suspend fun ApplicationCall.v1Payment(paymentService: PaymentServiceInterface, loanIdKey: String) {
    val payment = receive<Payment>()
    payment.loanId = loanIdKey

    val clientId = try {
        getClientAttributeId()!!
    } catch (e: NumberFormatException) {
        respond(Message("Client id must be between 1 and ${Int.MAX_VALUE}"))
        return
    } catch (e: KotlinNullPointerException) {
        respond(Message("Missing client id"))
        return
    }

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

    val loanId = payment.loanId!!.toInt()

    val date =
        try {
            paymentService.add(paymentDomain, loanId, clientId)
        } catch (e: Exception) {

            //TODO add Exceptions handler
            return
        }

    respond(mapOf("paymentExecutedAt" to date))
}
