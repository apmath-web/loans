package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.ResultCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanFromCalculationsResultInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.infrastructure.models.loans.LoanFromCalculationsResult
import com.apmath.loans.infrastructure.models.payments.PaymentFromCalculation

data class ResultCalculationsPayment(
    override val loan: LoanFromCalculationsResult,
    override val payment: PaymentFromCalculation
):ResultCalculationsPaymentInterface
