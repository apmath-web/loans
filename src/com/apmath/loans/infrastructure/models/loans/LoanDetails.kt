package com.apmath.loans.infrastructure.models.loans

import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.loans.LoanDetailsInterface

data class LoanDetails(
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanDetailsInterface
