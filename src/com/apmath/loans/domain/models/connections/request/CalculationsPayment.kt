package com.apmath.loans.domain.models.connections.request

class CalculationsPayment(
    override val loanInterface: LoanInterface,
    override val paymentInterface: PaymentInterface?,
    override val lastPayment: LastPaymentInterface
) : CalculationsPaymentInterface {
}
