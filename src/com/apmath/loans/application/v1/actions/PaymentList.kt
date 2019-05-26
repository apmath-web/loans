package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.NotFoundException
import com.apmath.loans.domain.exceptions.LoanNotFoundException
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.loans.domain.models.loans.Loan as LoanModel
import com.apmath.loans.domain.models.payments.Payment as PaymentModel
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1ListPayments(paymentService: PaymentServiceInterface, loanId: Int?){
    val loanIdHeader = getLoanId(request)

    val payments =
            try {
                paymentService.get(loanIdHeader, loanId)
            } catch (e: LoanNotFoundException) {
                 NotFoundException("Loan not found")
            }

    respond(mapOf("payments" to payments))
}
