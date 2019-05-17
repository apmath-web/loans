package com.apmath.loans.application.v1.mappers

import com.apmath.loans.application.v1.models.outgoing.ResponseLoan
import com.apmath.loans.domain.models.loans.LoanInterface

class LoanMapper {
    fun map(domainLoan: LoanInterface, isService: Boolean): ResponseLoan {

        val loan = ResponseLoan()

        loan.run {
            clientId = domainLoan.clientId
            applicationId = domainLoan.applicationId
            amount = domainLoan.amount
            term = domainLoan.term
            interest = domainLoan.interest
            currency = domainLoan.currency
            date = domainLoan.date
            completed = domainLoan.completed
            if (isService) {
                rounding = domainLoan.rounding
                regularPaymentAmount = domainLoan.regularPaymentAmount
                remainingTerm = domainLoan.remainingTerm
            }
        }

        return loan
    }
}
