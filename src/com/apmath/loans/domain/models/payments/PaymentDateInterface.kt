package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Money
import java.time.LocalDate

interface PaymentDateInterface {
    val date: String
    val amount: Money
}
