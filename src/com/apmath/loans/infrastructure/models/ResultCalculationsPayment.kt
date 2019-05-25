package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.ResultCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanFromCalculationsResultInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface

class ResultCalculationsPayment(
    override val loan: LoanFromCalculationsResultInterface,
    override val payment: PaymentFromCalculationInterface
):ResultCalculationsPaymentInterface
