package com.apmath.loans.domain.models.connections.response

import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

class Payment(
    override val date: String,
    override val amount: Money,
    override val percent: Int,
    override val body: Money,
    override val type: Type,
    override val remainCreditBody: Money,
    override val fullEarlyRepayment: Money
) : PaymentInterface {
}
