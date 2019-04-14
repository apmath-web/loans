package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.CalculationsPaymentInterface
import com.apmath.loans.domain.models.calculation.request.LastPaymentInterface
import com.apmath.loans.domain.models.calculation.request.LoanInterface
import com.apmath.loans.domain.models.calculation.request.PaymentInterface

class CalculationsPayment(
    override val loan: LoanInterface,
    override val payment: PaymentInterface?,
    override val lastPayment: LastPaymentInterface
) : CalculationsPaymentInterface
