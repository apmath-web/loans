package com.apmath.loans.domain.models.calculation.request

interface CalculationsPaymentInterface {
    val loanForCalculations: LoanForCalculationsInterface
    val paymentDate: PaymentDateInterface?
    val paymentLast: PaymentLastInterface
}
