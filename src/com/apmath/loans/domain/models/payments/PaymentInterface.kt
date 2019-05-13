package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money

interface PaymentInterface {
    val payment: Money
    val currency: Currency
    val date: String
    val clientId: Int
}
