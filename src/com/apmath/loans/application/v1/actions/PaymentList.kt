package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.MixedLoan
import com.apmath.loans.application.v1.models.toMixedLoanId
import com.apmath.loans.application.v1.validators.MixedLoanBuilder
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import com.apmath.loans.domain.models.loans.Loan as LoanModel
import com.apmath.loans.domain.models.payments.Payment as PaymentModel
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListPayments(){
    val mixed = MixedLoan(
        getUserId(request), //для проверки, смотрит ли клиент свой лоан, брать айди лоана и чекать, принадлежит ли он ему
        request.headers["service"],
        parameters["id"]
    )

    val validator = MixedLoanBuilder()
        .prepend("loanIdHeader", NullableValidator())
        .prepend("serviceIdHeader", NullableValidator())
        .prepend("loanId", RequiredValidator())
        .build()

    if (!validator.validate(mixed)) {
        respond(validator.messages)
        return
    }

    val mixedId = mixed.toMixedLoanId()

}
