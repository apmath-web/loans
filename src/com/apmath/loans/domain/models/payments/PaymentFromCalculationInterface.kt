package com.apmath.loans.domain.models.payments

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Type
import java.time.LocalDate

interface PaymentFromCalculationInterface {
    val date: LocalDate
    val amount: Money
    val percent: Int
    val body: Money
    val type: Type
    val remainCreditBody: Money
    val fullEarlyRepayment: Money
}
