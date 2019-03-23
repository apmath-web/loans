package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Money

interface LoanClientInterface {
    val amount: Money
    val term: Int
    val interest: Money
    val date: String
}
