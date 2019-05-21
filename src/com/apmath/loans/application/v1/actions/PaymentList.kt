package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.MixedLoan
import com.apmath.loans.application.v1.models.toMixedLoanId
import com.apmath.loans.application.v1.validators.MixedLoanBuilder
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.validation.simple.NullableValidator
import com.apmath.validation.simple.RequiredValidator
import com.apmath.loans.domain.models.loans.Loan as LoanModel
import com.apmath.loans.domain.models.payments.Payment as PaymentModel
import io.ktor.application.ApplicationCall
import io.ktor.response.respond


//TODO rewrite @rgimranova
suspend fun ApplicationCall.v1ListPayments(paymentService: PaymentServiceInterface){
    val mixed = MixedLoan(
        getUserId(request),
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

    val mixedLoanId = mixed.toMixedLoanId()
    val payments =
            try {
                paymentService.get(mixedLoanId)
            } catch (e:Exception) {
                //TODO Exceptions
                return
            }

    respond(mapOf("payments" to payments))
}
