package com.apmath.loans.infrastructure.models.loans

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.loans.LoanFromCalculationsResultInterface

data class LoanFromCalculationsResult (
    override val remainingTerm: Int,
    override val regularPaymentAmount: Money
) : LoanFromCalculationsResultInterface
