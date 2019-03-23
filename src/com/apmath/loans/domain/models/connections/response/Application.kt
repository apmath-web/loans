package com.apmath.loans.domain.models.connections.response

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Status

class Application(
    override val amount: Money,
    override val currency: Currency,
    override val period: Int,
    override val status: Status
) : ApplicationInterface {
}