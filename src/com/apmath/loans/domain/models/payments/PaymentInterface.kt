package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

interface PaymentInterface {
    val payment: Money
    val currency: Currency
    val date: String
}
