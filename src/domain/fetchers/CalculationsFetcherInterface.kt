package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.Loan
import com.apmath.loans.domain.models.connections.calculation.response.LoanDetailsInterface

interface CalculationsFetcherInterface {
    suspend fun initialization(loan: Loan): LoanDetailsInterface
}
