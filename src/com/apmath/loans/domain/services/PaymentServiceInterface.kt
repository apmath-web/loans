package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.MixedLoanIdInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface

interface PaymentServiceInterface {
    suspend fun get(isService: Boolean, loanIdHeader: Int?, loanId: Int?) : Array<PaymentFromCalculationInterface>
}
