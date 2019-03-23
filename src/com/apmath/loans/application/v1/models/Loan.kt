package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

class Loan(
    override val application: Int,
    override val amount: Money,
    override val currency: Currency,
    override val term: Int,
    override val date: String
) : LoanInterface {
}
