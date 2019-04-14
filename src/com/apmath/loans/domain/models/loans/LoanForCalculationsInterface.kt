package com.apmath.loans.domain.models.calculation.request

import com.apmath.loans.domain.models.data.Money

interface LoanForCalculationsInterface {
    val interest: Int
    val date: String
    val remainingTerm: Int
    val rounding: Int
    val regularPaymentAmount: Money
}
