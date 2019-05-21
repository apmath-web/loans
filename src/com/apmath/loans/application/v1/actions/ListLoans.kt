package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.ForbiddenException
import com.apmath.loans.application.v1.mappers.LoansMapper
import com.apmath.loans.domain.exceptions.ForbiddenAccessException
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.validation.simple.Message
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListLoans(loanService: LoanServiceInterface) {
    val isService = isService(request)
    val clientIdHeader = getUserId(request)

    val clientId = try {
        getClientAttributeId(this)
    } catch (e: NumberFormatException) {
        respond(Message("Client id must be between 1 and ${Int.MAX_VALUE}"))
        return
    }

    val loans =
        try {
            loanService.get(isService, clientIdHeader, clientId)
        } catch (e: ForbiddenAccessException) {
            throw ForbiddenException("Permission denied")
        }

    val loansResponse = LoansMapper().map(loans,isService)

    respond(mapOf("loans" to loansResponse))
}

private fun getClientAttributeId(call: ApplicationCall): Int? {

    val userHeaderKey = "client"

    if (call.parameters.contains(userHeaderKey)) {
        return call.parameters[userHeaderKey]?.toInt()
    }

    return null
}
