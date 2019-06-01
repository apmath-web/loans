package com.apmath.loans.infrastructure.models.loans

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.loans.LoanFromCalculationsResultInterface

class LoanFromCalculationsResult (
    override val remainingTerm: Int,
    override val regularPaymentAmount: Money
) : LoanFromCalculationsResultInterface
