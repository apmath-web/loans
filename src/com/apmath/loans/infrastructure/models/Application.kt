package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.ApplicationInterface
import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Status

data class Application(
    override val amount: Money,
    override val currency: Currency,
    override val period: Int,
    override val status: Status,

    override val clientId: Int,
    override val interest: Int,
    override val maxAmount: Money,
    override val minAmount: Money
) : ApplicationInterface
