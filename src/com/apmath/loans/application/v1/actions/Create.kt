package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Loan
import com.apmath.loans.application.v1.models.toLoanClient
import com.apmath.loans.application.v1.validators.LoanBuilder
import com.apmath.loans.domain.exceptions.ApiException
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

suspend fun ApplicationCall.v1Create(loanService: LoanServiceInterface) {
    val loan = receive<Loan>()
    loan.clientId = getUserId(request)

    val validator = LoanBuilder()
        .prepend("clientId", RequiredValidator())
        .prepend("applicationId", RequiredValidator())
        .prepend("amount", RequiredValidator())
        .prepend("currency", RequiredValidator())
        .prepend("term", RequiredValidator())
        .prepend("date", RequiredValidator())
        .build()

    if (!validator.validate(loan)) {
        respond(validator.messages)
        return
    }

    val loanDomain = loan.toLoanClient()
    val loanId: Int =
        try {
            loanService.add(loanDomain)
        } catch (e: Exception) {
            respondError(e)
            return
        }

    respond(Response(loanId))
}

suspend fun ApplicationCall.respondError(e: Exception) {
    if (e is ApiException)
        respond(e.code, e.message)
    else
        respond(HttpStatusCode.InternalServerError, "Something went wrong")
}

data class Response(val loanId: Int)
