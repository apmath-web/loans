package com.apmath.loans.domain.models.connections.calculation.request

import com.apmath.loans.domain.models.data.Money

interface LoanInitializationInterface {
    val amount: Money
    val term: Int
    val interest: Int
    val date: String
}
