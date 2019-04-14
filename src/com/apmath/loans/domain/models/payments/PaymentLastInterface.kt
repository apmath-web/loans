package com.apmath.loans.domain.models.calculation.request

import com.apmath.loans.domain.models.data.Money

interface PaymentLastInterface {
    val date: String
    val amount: Money
    val remainCreditBody: Money
}
