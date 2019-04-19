package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.CalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.models.payments.PaymentDateInterface
import com.apmath.loans.domain.models.payments.PaymentLastInterface

data class CalculationsPayment(
    override val loanForCalculations: LoanForCalculationsInterface,
    override val paymentDate: PaymentDateInterface?,
    override val paymentLast: PaymentLastInterface
) : CalculationsPaymentInterface
