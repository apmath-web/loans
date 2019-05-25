package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Money

interface PaymentDateInterface {
    val date: String
    val amount: Money
}
