package com.apmath.loans.infrastructure.models.loans

import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.data.Money

class LoanForCalculations(
    override val amount: Money?,
    override val term: Int?,
    override val interest: Float,
    override val date: String,
    override val remainingTerm: Int?,
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanForCalculationsInterface
