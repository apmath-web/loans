package com.apmath.loans.infrastructure.models.payments

import com.apmath.loans.domain.models.payments.PaymentLastInterface
import com.apmath.loans.domain.data.Money

data class PaymentLast(
    override val date: String,
    override val body: Money,
    override val remainCreditBody: Money
) : PaymentLastInterface
