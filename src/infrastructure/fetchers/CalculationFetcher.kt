package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.LoanClient
import com.apmath.loans.domain.models.connections.calculation.response.LoanDetailsInterface

class CalculationFetcher : CalculationsFetcherInterface{
    override suspend fun initialization(loan: LoanClient): LoanDetailsInterface {
        TODO("not implemented")
    }
}
