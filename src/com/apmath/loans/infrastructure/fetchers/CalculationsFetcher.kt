package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.loans.LoanDetailsInterface
import com.apmath.loans.domain.models.loans.LoanInitializationInterface

class CalculationsFetcher : CalculationsFetcherInterface{
    override suspend fun initialization(loan: LoanInitializationInterface): LoanDetailsInterface {
        TODO("not implemented")
    }
}
