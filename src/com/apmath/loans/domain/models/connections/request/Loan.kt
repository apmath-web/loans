package com.apmath.loans.domain.models.connections.request

import com.apmath.loans.domain.models.data.Money

class Loan(
    override val interest: Int,
    override val date: String,
    override val remainingTerm: Int,
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanInterface {
}
