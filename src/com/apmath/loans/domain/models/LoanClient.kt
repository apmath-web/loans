package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Money

class LoanClient(
    override var id: Int?,
    override val isFinished: Boolean,
    override val amount: Money,
    override val term: Int,
    override val interest: Money,
    override val date: String
) : LoanClientInterface {
}
