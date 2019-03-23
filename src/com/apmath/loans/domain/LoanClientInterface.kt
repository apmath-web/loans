package com.apmath.loans.domain

import com.apmath.loans.domain.data.Money

interface LoanClientInterface {
    val amount: Money
    val term: Int
    val interest: Money
    val date: String
}
