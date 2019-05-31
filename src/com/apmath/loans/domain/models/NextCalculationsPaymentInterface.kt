package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.models.payments.PaymentDateInterface
import com.apmath.loans.domain.models.payments.PaymentLastInterface

interface NextCalculationsPaymentInterface {
    val loan: LoanForCalculationsInterface
    val lastPayment: PaymentLastInterface?
    val payment: PaymentDateInterface
}
