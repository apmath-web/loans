package com.apmath.loans.application.v1.models.incoming

import com.apmath.loans.domain.models.loans.LoanCreationData as LoanDomain
import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money

class Loan {
    var clientId: Int? = null
    var applicationId: Int? = null
    var amount: Money? = null
    var currency: Currency? = null
    var term: Int? = null
    var date: String? = null
}

fun Loan.toLoanClient() = LoanDomain(
    clientId = clientId!!,
    applicationId = applicationId!!,
    amount = amount!!,
    currency = currency!!,
    term = term!!,
    date = date!!
)
