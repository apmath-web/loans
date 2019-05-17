package com.apmath.loans.application.v1.mappers

import com.apmath.loans.application.v1.models.out.ResponseLoan
import com.apmath.loans.domain.models.loans.LoanInterface

class LoansMapper {
    fun map(domainLoans: Array<LoanInterface>, isService: Boolean): Array<ResponseLoan> {

        val loanMapper = LoanMapper()

        return domainLoans.map { domainLoan -> loanMapper.map(domainLoan, isService) }.toTypedArray()
    }
}
