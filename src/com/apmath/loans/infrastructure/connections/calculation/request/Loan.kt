package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.LoanInterface
import com.apmath.loans.domain.models.data.Money

class Loan(
    override val interest: Int,
    override val date: String,
    override val remainingTerm: Int,
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanInterface
