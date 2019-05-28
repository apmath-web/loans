package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.NotFoundException
import com.apmath.loans.domain.exceptions.LoanNotFoundException
import com.apmath.loans.domain.services.PaymentServiceInterface
import io.ktor.application.ApplicationCall
import io.ktor.response.respond
import com.apmath.loans.domain.models.loans.Loan as LoanModel
import com.apmath.loans.domain.models.payments.Payment as PaymentModel

suspend fun ApplicationCall.v1ListPayments(
    paymentService: PaymentServiceInterface,
    loanIdParam: String,
    clientIdParam: String?
) {
    val loanId = getAndValidateLoanId(loanIdParam)
    val userId = getAndValidateClientId(clientIdParam)

    val payments =
        try {
            paymentService.get(loanId, userId)
        } catch (e: LoanNotFoundException) {
            NotFoundException("Loan not found")
        }

    respond(mapOf("payments" to payments))
}
