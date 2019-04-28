package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.models.payments.PaymentDateInterface
import com.apmath.loans.domain.models.payments.PaymentLastInterface

interface CalculationsPaymentInterface {
    val loanForCalculations: LoanForCalculationsInterface
    val paymentDate: PaymentDateInterface?
    val paymentLast: PaymentLastInterface
}
