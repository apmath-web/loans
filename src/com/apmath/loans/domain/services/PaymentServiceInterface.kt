package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface

interface PaymentServiceInterface {
    suspend fun get(isService: Boolean, loanIdHeader: Int?, loanId: Int?) : Array<PaymentFromCalculationInterface>
}
