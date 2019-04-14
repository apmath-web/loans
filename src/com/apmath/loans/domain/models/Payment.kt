package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

class Payment(
    override val payment: Money,
    override val currency: Currency,
    override val date: String
) : PaymentInterface
