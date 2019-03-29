package com.apmath.loans.domain.models.connections.request

import com.apmath.loans.domain.models.data.Money

interface LastPaymentInterface {
    val date: String
    val amount: Money
    val remainCreditBody: Money
}
