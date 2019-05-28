package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Money
import java.time.LocalDate

interface PaymentLastInterface {
    val date: String
    val body: Money
    val remainCreditBody: Money
}
