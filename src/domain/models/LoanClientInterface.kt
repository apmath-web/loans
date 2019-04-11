package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.calculation.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money

interface LoanClientInterface {
    val clientId: Int
    val applicationId: Int

    val amount: Money
    val term: Int
    val interest: Money
    val currency: Currency
    val date: String
    val completed: Boolean
}
