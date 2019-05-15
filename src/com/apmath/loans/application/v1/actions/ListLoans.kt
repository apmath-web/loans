package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.respondError
import com.apmath.loans.domain.services.LoanServiceInterface
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListLoans(loanService: LoanServiceInterface) {
    val isService = isService(request)
    val clientIdHeader = getUserId(request)

    val clientId = try {
        getClientAttributeId(this)
    } catch (e: NumberFormatException) {
        respond("Client id must be between 1 and ${Int.MAX_VALUE}")
        return
    }

    val loans =
        try {
            loanService.get(isService, clientIdHeader, clientId)
        } catch (e: Exception) {
            respondError(e)
            return
        }

    respond(mapOf("loans" to loans))
}

@Throws
private fun getClientAttributeId(call: ApplicationCall): Int? {

    val userHeaderKey = "client"

    if (call.parameters.contains(userHeaderKey)) {
        return call.parameters[userHeaderKey]?.toInt()
    }

    return null
}
