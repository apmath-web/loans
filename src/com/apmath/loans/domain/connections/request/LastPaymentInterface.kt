package com.apmath.loans.domain.connections.request

import com.apmath.loans.domain.data.Money

interface LastPaymentInterface {
    val date: String
    val amount: Money
    val remainCreditBody: Money
}
