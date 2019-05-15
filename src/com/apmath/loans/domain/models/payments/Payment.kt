package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import java.time.LocalDate

data class Payment(
    override val payment: Money,
    override val currency: Currency,
    override val date: LocalDate,
    override val clientId: Int
) : PaymentInterface
