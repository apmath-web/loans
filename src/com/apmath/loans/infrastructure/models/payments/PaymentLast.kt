package com.apmath.loans.infrastructure.models.payments

import com.apmath.loans.domain.models.payments.PaymentLastInterface
import com.apmath.loans.domain.data.Money
import java.time.LocalDate

class PaymentLast(
    override val date: LocalDate,
    override val body: Money,
    override val remainCreditBody: Money
) : PaymentLastInterface
