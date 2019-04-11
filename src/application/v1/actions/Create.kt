package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Loan
import com.apmath.loans.application.v1.models.toLoanClient
import com.apmath.loans.application.v1.validators.LoanBuilder
import com.apmath.loans.infrastructure.connections.ServiceManager
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.request.receive
import io.ktor.response.respond

suspend fun ApplicationCall.v1Create() {
    println("Create")
    val loan = receive<Loan>()
    loan.clientId = getUserId(request)
    println(loan)

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

    val service = ServiceManager.instance.getLoanService()
    val loanId = service.add(loanDomain)

    respond(Response(loanId))
}

data class Response(val loanId: Int)
