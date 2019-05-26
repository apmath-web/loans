package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.ResultCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanDetailsInterface
import com.apmath.loans.domain.models.loans.LoanInitializationInterface

interface CalculationsFetcherInterface {
    suspend fun initialization(loan: LoanInitializationInterface): LoanDetailsInterface
    suspend fun nextNewPayment(paymentData : NextCalculationsPaymentInterface): ResultCalculationsPaymentInterface
    suspend fun nextPayment(paymentData : NextCalculationsPaymentInterface): ResultCalculationsPaymentInterface
}
