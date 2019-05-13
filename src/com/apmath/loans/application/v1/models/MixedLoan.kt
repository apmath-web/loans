package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.MixedLoanId
import com.apmath.loans.infrastructure.fetchers.Host

data class MixedLoan(
    var loanIdHeader: Int?,
    var serviceIdHeader: String?,
    var loanId: String?
)

fun MixedLoan.toMixedLoanId() = MixedLoanId(
    when (serviceIdHeader){
        Host.APPLICATIONS.value, Host.CALCULATIONS.value, Host.CLIENTS.value -> false
        else                                                                 -> true
    },
    loanIdHeader,
    loanId?.toInt()!!
)
