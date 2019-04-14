package com.apmath.loans.domain.models.calculation.request

interface CalculationsPaymentInterface {
    val loan: LoanInterface
    val payment: PaymentInterface?
    val lastPayment: LastPaymentInterface
}
