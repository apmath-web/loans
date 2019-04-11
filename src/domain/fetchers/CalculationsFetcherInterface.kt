package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.LoanClient
import com.apmath.loans.domain.models.connections.calculation.response.LoanDetailsInterface

interface CalculationsFetcherInterface {
    suspend fun initialization(loan: LoanClient): LoanDetailsInterface
}
