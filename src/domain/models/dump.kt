package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money
import domain.models.LoanEmployee

//TODO: replace dump
class Loan(
    val clientId: Int,
    val applicationId: Int,

    val amount: Money,
    val currency: Currency,
    val term: Int,
    val date: String
)
