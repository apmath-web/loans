package com.apmath.loans.infrastructure.aplications.response

import com.apmath.loans.domain.models.application.response.ApplicationInterface
import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Status

data class Application(
    override val amount: Money,
    override val currency: Currency,
    override val period: Int,
    override val status: Status
) : ApplicationInterface