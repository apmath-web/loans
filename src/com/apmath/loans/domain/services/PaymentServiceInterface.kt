package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.MixedIdInterface
import com.apmath.loans.domain.models.MixedLoanIdInterface
import com.apmath.loans.domain.models.payments.Payment
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface

interface PaymentServiceInterface {
    suspend fun get(mixedLoanId: MixedLoanIdInterface) : Array<PaymentFromCalculationInterface>
    suspend fun add(payment: Payment) : String
}
