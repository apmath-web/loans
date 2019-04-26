package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Money

interface LoanForCalculationsInterface {
    val interest: Int
    val date: String
    val remainingTerm: Int
    val rounding: Int
    val regularPaymentAmount: Money
}
