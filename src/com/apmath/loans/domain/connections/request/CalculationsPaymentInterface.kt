package com.apmath.loans.domain.connections.request

interface CalculationsPaymentInterface {
    val loanInterface: LoanInterface
    val paymentInterface: PaymentInterface?
    val lastPayment: LastPaymentInterface
}
