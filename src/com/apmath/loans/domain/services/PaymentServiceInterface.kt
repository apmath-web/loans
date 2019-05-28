package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.payments.PaymentInterface
import java.time.LocalDate
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface

interface PaymentServiceInterface {
    suspend fun get(loanIdHeader: Int?, loanId: Int?) : Array<PaymentFromCalculationInterface>
    suspend fun add(payment: PaymentInterface, loanId: Int, clientId: Int): LocalDate
}
