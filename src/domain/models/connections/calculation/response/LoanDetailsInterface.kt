package com.apmath.loans.domain.models.connections.calculation.response

import com.apmath.loans.domain.models.data.Money

interface LoanDetailsInterface {
    val rounding: Int
    val regularPaymentAmount: Money
}
