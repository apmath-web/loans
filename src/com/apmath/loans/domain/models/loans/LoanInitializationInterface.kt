package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Money

interface LoanInitializationInterface {
    val amount: Money
    val term: Int
    val interest: Float
    val date: String
}
