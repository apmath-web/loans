package com.apmath.loans.infrastructure.models.payments

import com.apmath.loans.domain.models.payments.PaymentDateInterface

data class PaymentDate(
    override val date: String
) : PaymentDateInterface
