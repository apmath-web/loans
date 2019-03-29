package com.apmath.loans.domain.models.connections.response

import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

interface PaymentInterface {
    val date: String
    val amount: Money
    val percent: Int
    val body: Money
    val type: Type
    val remainCreditBody: Money
    val fullEarlyRepayment: Money
}
