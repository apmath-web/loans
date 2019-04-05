package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.calculation.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money

interface LoanClientInterface {
    var id: Int?

    val completed: Boolean
    val amount: Money
    val term: Int
    val interest: Money
    val date: String
}
