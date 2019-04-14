package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.LoanForCalculationsInterface
import com.apmath.loans.domain.models.data.Money

data class LoanForCalculations(
    override val interest: Int,
    override val date: String,
    override val remainingTerm: Int,
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanForCalculationsInterface
