package com.apmath.loans.infrastructure.connections.calculation.response

import com.apmath.loans.domain.models.connections.calculation.response.LoanDetailsInterface
import com.apmath.loans.domain.models.data.Money

class LoanDetails(
    override val rounding: Int,
    override val regularPaymentAmount: Money
) : LoanDetailsInterface
