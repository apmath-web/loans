package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.models.payments.PaymentDateInterface
import com.apmath.loans.domain.models.payments.PaymentLastInterface

data class NextCalculationsPayment(
    override val loan: LoanForCalculationsInterface,
    override val lastPayment: PaymentLastInterface?,
    override val payment: PaymentDateInterface
) : NextCalculationsPaymentInterface
