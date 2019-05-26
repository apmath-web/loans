package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.ApplicationInterface
import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Status

data class Application(
    override val amount: Money,
    override val currency: Currency,
    override val term: Int
) : ApplicationInterface
