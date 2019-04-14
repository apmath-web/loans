package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.PaymentLastInterface
import com.apmath.loans.domain.models.data.Money

class PaymentLast(
    override val date: String,
    override val amount: Money,
    override val remainCreditBody: Money
) : PaymentLastInterface
