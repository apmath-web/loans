package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.incoming.Payment
import com.apmath.loans.application.v1.models.incoming.toPaymentDomain
import com.apmath.loans.application.v1.validators.PaymentBuilder
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.http.Parameters
import io.ktor.request.receive
import io.ktor.response.respond


suspend fun ApplicationCall.v1Payment (paymentService: PaymentServiceInterface){
    val payment = receive<Payment>()
    payment.clientId = getUserId(request)
    payment.loanId = getLoanId(parameters)

    val validator = PaymentBuilder()
        .prepend("payment", RequiredValidator())
        .prepend("currency", RequiredValidator())
        .prepend("date", NullableValidator())
        .prepend("clientId", RequiredValidator())
        .prepend("loanId", RequiredValidator())
        .build()

    if (!validator.validate(payment)) {
        respond(validator.messages)
        return
    }

    val paymentDomain = payment.toPaymentDomain()

    val date =
            try {
                paymentService.add(paymentDomain)
            } catch (e:Exception) {

                //TODO add Exceptions handler
                return
            }

    respond(mapOf("paymentExecutedAt" to date))
}

fun getLoanId(parameters: Parameters): Int? {

    val loanId = "id"

    if (parameters.contains(loanId)) {
        try {
            return parameters[loanId]?.toInt()
        } catch (e: NumberFormatException) {

        }
    }

    return null
}
