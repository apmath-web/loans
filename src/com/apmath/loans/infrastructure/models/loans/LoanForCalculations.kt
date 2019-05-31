package com.apmath.loans.infrastructure.models.loans

import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.data.Money

data class LoanForCalculations(
    override val amount: Money?,
    override val term: Int?,
    override val interest: Int,
    override val date: String,
    override val remainingTerm: Int?,
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanForCalculationsInterface
