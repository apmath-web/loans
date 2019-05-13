package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.payments.Payment as PaymentDomain

class Payment {
    var payment: Money? = null
    var currency: Currency? = null
    var date: String? = null
    var clientId: Int? = null
}

fun Payment.toPayment() = PaymentDomain (
    payment!!,
    currency!!,
    date!!,
    clientId!!
)
