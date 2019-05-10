package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.MixedIdInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface

interface PaymentServiceInterface {
    suspend fun add(payment: PaymentInterface) : PaymentInterface
    suspend fun get(mixedId: MixedIdInterface) : Array<PaymentFromCalculationInterface>
}