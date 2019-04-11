package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

class LoanClient(
    override val clientId: Int,
    override val applicationId: Int,

    override val amount: Money,
    override val term: Int,
    override val interest: Money,
    override val currency: Currency,
    override val date: String,
    override val completed: Boolean
) : LoanClientInterface
