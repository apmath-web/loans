package com.apmath.loans.application.v1

import com.apmath.loans.application.v1.actions.v1Create
import com.apmath.loans.application.v1.actions.v1Info
import com.apmath.loans.application.v1.actions.v1ListLoans
import com.apmath.loans.application.v1.actions.v1ListPayments
import com.apmath.loans.application.v1.exceptions.ApiException
import com.apmath.loans.application.v1.exceptions.BadRequestValidationException
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.PathMessageInterface
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
        get {
            call.v1ListLoans(loanService)
        }
        get ("{id}/payments"){
            val parameters = call.parameters
            call.v1ListPayments(paymentService, parameters["id"]!!)
        }
    }
}

suspend fun ApplicationCall.respondApiException(e: ApiException) {
    when {
        e is BadRequestValidationException -> {

            val description: HashMap<String, String> = HashMap()
            e.messages.forEach {
                if (it is PathMessageInterface) {
                    description[it.path] = it.message
                }
            }

            respond(
                e.code,
                mapOf("message" to e.message!!, "description" to description)
            )
        }
        e.message != null -> respond(e.code,  mapOf("message" to e.message!!))
        else -> respond(e.code, mapOf("message" to e.javaClass))
    }
}
