package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.CalculationsPaymentInterface
import com.apmath.loans.domain.models.calculation.request.PaymentLastInterface
import com.apmath.loans.domain.models.calculation.request.LoanForCalculationsInterface
import com.apmath.loans.domain.models.calculation.request.PaymentDateInterface

class CalculationsPayment(
    override val loanForCalculations: LoanForCalculationsInterface,
    override val paymentDate: PaymentDateInterface?,
    override val paymentLast: PaymentLastInterface
) : CalculationsPaymentInterface
