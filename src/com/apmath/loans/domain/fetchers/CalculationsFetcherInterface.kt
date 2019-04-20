package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.loans.LoanInitializationInterface
import com.apmath.loans.infrastructure.models.loans.LoanDetails

interface CalculationsFetcherInterface {
    suspend fun initialization(loan: LoanInitializationInterface): LoanDetails
}
