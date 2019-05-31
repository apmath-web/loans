package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.loans.LoanFromCalculationsResultInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface

interface ResultCalculationsPaymentInterface {
    val loan: LoanFromCalculationsResultInterface
    val payment: PaymentFromCalculationInterface
}
