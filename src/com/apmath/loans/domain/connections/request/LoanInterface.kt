package com.apmath.loans.domain.connections.request

import com.apmath.loans.domain.data.Money

interface LoanInterface {
    val interest: Int
    val date: String
    val remainingTerm: Int
    val rounding: Int
    val regularPaymentAmount: Money
}
