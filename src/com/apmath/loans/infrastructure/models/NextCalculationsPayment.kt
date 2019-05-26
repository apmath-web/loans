package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.Loan
import com.apmath.loans.domain.models.loans.LoanForCalculationsInterface
import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.payments.PaymentDateInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentLastInterface
import com.apmath.loans.infrastructure.models.loans.LoanForCalculations
import com.apmath.loans.infrastructure.models.payments.PaymentDate
import com.apmath.loans.infrastructure.models.payments.PaymentLast

data class NextCalculationsPayment(
    override val loan: LoanForCalculationsInterface,
    override val payment: PaymentDateInterface,
    override val lastPayment: PaymentLastInterface?
    ) : NextCalculationsPaymentInterface
