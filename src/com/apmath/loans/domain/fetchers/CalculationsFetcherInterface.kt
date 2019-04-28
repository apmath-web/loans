package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.loans.LoanDetailsInterface
import com.apmath.loans.domain.models.loans.LoanInitializationInterface

interface CalculationsFetcherInterface {
    suspend fun initialization(loan: LoanInitializationInterface): LoanDetailsInterface
}
