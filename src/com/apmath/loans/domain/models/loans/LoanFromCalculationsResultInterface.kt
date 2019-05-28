package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Money

interface LoanFromCalculationsResultInterface {
    val remainingTerm: Int
    val regularPaymentAmount: Money
}
