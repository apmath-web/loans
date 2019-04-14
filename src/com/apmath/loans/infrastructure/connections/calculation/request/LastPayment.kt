package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.LastPaymentInterface
import com.apmath.loans.domain.models.data.Money

class LastPayment(
    override val date: String,
    override val amount: Money,
    override val remainCreditBody: Money
) : LastPaymentInterface
