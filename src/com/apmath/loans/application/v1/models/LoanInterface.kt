package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

interface LoanInterface {
    val application: Int
    val amount: Money
    val currency: Currency
    val term: Int
    val date: String
}
