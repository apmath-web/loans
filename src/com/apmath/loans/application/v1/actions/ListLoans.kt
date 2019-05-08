package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Mixed
import com.apmath.loans.application.v1.models.response.ListLoansResponse
import com.apmath.loans.application.v1.models.toMixedId
import com.apmath.loans.application.v1.respondError
import com.apmath.loans.application.v1.validators.MixedBuilder
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.validation.simple.NullableValidator
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListLoans(loanService: LoanServiceInterface) {
    val mixed = Mixed(
        getUserId(request),
        request.headers["service"],
        parameters["client"]
    )

    val validator = MixedBuilder()
        .prepend("clientIdHeader", NullableValidator())
        .prepend("serviceIdHeader", NullableValidator())
        .prepend("clientId", NullableValidator())
        .build()

    if (!validator.validate(mixed)) {
        respond(validator.messages)
        return
    }

    val mixedId = mixed.toMixedId()
    val loans =
        try {
            loanService.get(mixedId)
        } catch (e: Exception) {
            respondError(e)
            return
        }

    respond(ListLoansResponse(loans))
}
