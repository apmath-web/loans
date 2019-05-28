package com.apmath.loans.infrastructure.models.loans

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.loans.LoanInitializationInterface

data class LoanInitialization(
    override val amount: Money,
    override val term: Int,
    override val interest: Int,
    override val date: String
) : LoanInitializationInterface
