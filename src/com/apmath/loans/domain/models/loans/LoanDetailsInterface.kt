package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Money

interface LoanDetailsInterface {
    val rounding: Int
    val regularPaymentAmount: Money
}
