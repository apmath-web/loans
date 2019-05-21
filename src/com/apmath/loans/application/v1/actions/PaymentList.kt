package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.NotFoundException
import com.apmath.loans.domain.exceptions.LoanNotFoundException
import com.apmath.loans.domain.services.PaymentServiceInterface
import com.apmath.loans.domain.models.loans.Loan as LoanModel
import com.apmath.loans.domain.models.payments.Payment as PaymentModel
import com.apmath.validation.simple.Message
import io.ktor.application.ApplicationCall
import io.ktor.response.respond
import java.lang.NumberFormatException

suspend fun ApplicationCall.v1ListPayments(paymentService: PaymentServiceInterface){
    val isService = isService(request)
    val loanIdHeader = getLoanId(request)

    val loanId = try {
        getLoanAttributeId(this)
    } catch (e: NumberFormatException) {
        respond(Message("Loan id must be between 1 and ${Int.MAX_VALUE}"))
        return
    }

    val payments =
            try {
                paymentService.get(isService, loanIdHeader, loanId)
            } catch (e: LoanNotFoundException) {
                 NotFoundException("Loan not found")
            }

    respond(mapOf("payments" to payments))
}

private fun getLoanAttributeId(call: ApplicationCall): Int? {

    val headerKey = "loan"

    if (call.parameters.contains(headerKey)) {
        return call.parameters[headerKey]?.toInt()
    }

    return null
}
