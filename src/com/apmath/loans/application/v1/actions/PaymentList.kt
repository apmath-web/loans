package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Mixed
import com.apmath.loans.application.v1.models.toMixedId
import com.apmath.loans.application.v1.validators.MixedBuilder
import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.repositories.Repository
import io.netty.handler.codec.http.*
import com.apmath.loans.domain.repositories.RepositoryInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.loans.domain.models.loans.Loan as LoanModel
import com.apmath.loans.domain.models.payments.Payment as PaymentModel
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListPayments(){
    val mixed = Mixed(
        getUserId(request),
        request.headers["service"],
        parameters["payment"]
    )

    val validator = MixedBuilder()
        .prepend("loanIdHeader", NullableValidator())
        .prepend("serviceIdHeader", NullableValidator())
        .prepend("loanId", NullableValidator())
        .build()

    if (!validator.validate(mixed)) {
        respond(validator.messages)
        return
    }

    val mixedId = mixed.toMixedId()

}

