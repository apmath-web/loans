package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.Loan
import com.apmath.loans.domain.models.connections.calculation.response.LoanDetailsInterface

class CalculationFetcher : CalculationsFetcherInterface{
    override suspend fun initialization(applicationId: Loan): LoanDetailsInterface {
        TODO("not implemented")
    }
}
