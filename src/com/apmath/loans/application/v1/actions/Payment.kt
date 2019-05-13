package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Payment
import com.apmath.loans.application.v1.models.toPayment
import com.apmath.loans.application.v1.respondError
import com.apmath.loans.application.v1.validators.PaymentBuilder
import com.apmath.loans.domain.services.PaymentService
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.request.receive
import io.ktor.response.respond

suspend fun ApplicationCall.v1Payment (paymentService: PaymentServiceInterface){
    val post = receive<Payment>()
    post.clientId = getUserId(request)

    val validator = PaymentBuilder()
        .prepend("payment", RequiredValidator())
        .prepend("currency", RequiredValidator())
        .prepend("date", NullableValidator())
        .prepend("clientId", RequiredValidator())
        .build()

    if (!validator.validate(post)) {
        respond(validator.messages)
        return
    }

    val paymentDomain = post.toPayment()

    val date =
            try {
                paymentService.add(paymentDomain)
            } catch (e:Exception) {
                respondError(e)
                return
            }

    respond(mapOf("paymentExecutedAt" to date))


}
