package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.calculation.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

interface LoanClientInterface {
    var id: Int?
    var completed: Boolean = false

    val amount: Money
    val term: Int
    val interest: Money
    val date: String
}
