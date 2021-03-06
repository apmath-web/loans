package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import java.time.LocalDate

interface PaymentServiceInterface {
    suspend fun get(loanId: Int, clientId: Int?) : Array<PaymentFromCalculationInterface>
    suspend fun add(payment: PaymentInterface, loanId: Int, clientId: Int?) : LocalDate
}
