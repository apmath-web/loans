package com.apmath.loans.domain.models.connections.request

interface CalculationsPaymentInterface {
    val loan: LoanInterface
    val payment: PaymentInterface?
    val lastPayment: LastPaymentInterface
}
