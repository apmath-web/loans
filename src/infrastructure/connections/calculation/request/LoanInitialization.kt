package com.apmath.loans.infrastructure.connections.calculation.request

import com.apmath.loans.domain.models.connections.calculation.request.LoanInitializationInterface
import com.apmath.loans.domain.models.data.Money

class LoanInitialization(
    override val amount: Money,
    override val term: Int,
    override val interest: Int,
    override val date: String
) : LoanInitializationInterface
