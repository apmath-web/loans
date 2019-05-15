package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.LoansListRequest
import com.apmath.loans.application.v1.respondError
import com.apmath.loans.application.v1.validators.MixedBuilder
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListLoans(loanService: LoanServiceInterface) {
    val request = LoansListRequest(
        getUserId(request),
        isService(request),
        getClientAttributeId(this)
    )

    val validator = MixedBuilder()
        .prepend("clientIdHeader", NullableValidator())
        .prepend("isService", RequiredValidator())
        .prepend("clientId", NullableValidator())
        .build()

    if (!validator.validate(request)) {
        respond(validator.messages)
        return
    }

    val loans =
        try {
            loanService.get(request.isService, request.clientIdHeader, request.clientId)
        } catch (e: Exception) {
            respondError(e)
            return
        }

    respond(mapOf("loans" to loans))
}

private fun getClientAttributeId(call: ApplicationCall): Int? {

    val userHeaderKey = "client"

    if (call.parameters.contains(userHeaderKey)) {
        try {
            return call.parameters[userHeaderKey]?.toInt()
        } catch (e: NumberFormatException) {

        }
    }

    return null
}
