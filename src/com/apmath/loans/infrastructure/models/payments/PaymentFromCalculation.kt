package com.apmath.loans.infrastructure.models.payments

import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Type
import java.time.LocalDate

data class PaymentFromCalculation(
    override val date: LocalDate,
    override val amount: Money,
    override val percent: Int,
    override val body: Money,
    override val type: Type,
    override val remainCreditBody: Money,
    override val fullEarlyRepayment: Money
) : PaymentFromCalculationInterface
