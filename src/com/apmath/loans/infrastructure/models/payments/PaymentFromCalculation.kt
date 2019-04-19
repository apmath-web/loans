package com.apmath.loans.infrastructure.calculation.response

import com.apmath.loans.domain.models.calculation.response.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

data class PaymentFromCalculation(
    override val date: String,
    override val amount: Money,
    override val percent: Int,
    override val body: Money,
    override val type: Type,
    override val remainCreditBody: Money,
    override val fullEarlyRepayment: Money
) : PaymentFromCalculationInterface
