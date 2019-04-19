package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.LoanClient as LoanDomain
import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

class Loan {
    var clientId: Int? = null
    var applicationId: Int? = null
    var amount: Money? = null
    var currency: Currency? = null
    var term: Int? = null
    var date: String? = null
}

//TODO: replace loanClient from dump
fun Loan.toLoanClient() = LoanDomain(
    clientId = clientId!!,
    applicationId = applicationId!!,
    amount = amount!!,
    currency = currency!!,
    term = term!!,
    date = date!!
)
