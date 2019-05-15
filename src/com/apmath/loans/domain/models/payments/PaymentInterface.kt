package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import java.time.LocalDate

interface PaymentInterface {
    val payment: Money
    val currency: Currency
    val date: LocalDate
    val clientId: Int
    val loanId: Int
}
