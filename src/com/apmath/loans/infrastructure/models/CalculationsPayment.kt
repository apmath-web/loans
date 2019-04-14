package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.CalculationsPaymentInterface
import com.apmath.loans.domain.models.calculation.request.LoanForCalculationsInterface
import com.apmath.loans.domain.models.calculation.request.PaymentDateInterface
import com.apmath.loans.domain.models.calculation.request.PaymentLastInterface

data class CalculationsPayment(
    override val loanForCalculations: LoanForCalculationsInterface,
    override val paymentDate: PaymentDateInterface?,
    override val paymentLast: PaymentLastInterface
) : CalculationsPaymentInterface
