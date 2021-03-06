package com.apmath.loans.infrastructure.models.payments

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.payments.PaymentDateInterface
import java.time.LocalDate

class PaymentDate(
    override val date: LocalDate,
    override val amount: Money) : PaymentDateInterface
