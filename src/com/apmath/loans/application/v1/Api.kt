package com.apmath.loans.application.v1

import com.apmath.loans.application.v1.actions.*
import com.apmath.loans.domain.exceptions.ApiException
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.loans.domain.services.PaymentService
import com.apmath.loans.domain.services.PaymentServiceInterface
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.util.error
import org.koin.ktor.ext.inject

internal fun Routing.v1() {

    v1Info()
    // other route groups here
}

private fun Routing.v1Info() {
    val loanService: LoanServiceInterface by inject()

    val paymentService: PaymentServiceInterface by inject()

    route("v1") {
        get("info") {
            call.v1Info()
        }
        post("loan") {
            call.v1Create(loanService)
        }
        get("{id}/payments"){
            call.v1ListPayments(paymentService)
        }
        post("{id}/payment"){
            call.v1Payment(paymentService)
        }
    }
}

suspend fun ApplicationCall.respondError(e: Exception) {
    application.environment.log.error(e)
    if (e is ApiException)
        respond(e.code, e.message)
    else
        respond(HttpStatusCode.InternalServerError, "Something went wrong")
}
