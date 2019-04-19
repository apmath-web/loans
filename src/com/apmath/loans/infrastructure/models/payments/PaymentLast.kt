package com.apmath.loans.infrastructure.models.payments

import com.apmath.loans.domain.models.payments.PaymentLastInterface
import com.apmath.loans.domain.models.data.Money

data class PaymentLast(
    override val date: String,
    override val amount: Money,
    override val remainCreditBody: Money
) : PaymentLastInterface
