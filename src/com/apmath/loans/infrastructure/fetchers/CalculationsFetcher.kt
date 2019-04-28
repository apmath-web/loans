package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.loans.LoanInitializationInterface
import com.apmath.loans.infrastructure.models.loans.LoanDetails

class CalculationsFetcher : AbstractFetcher(
    Host.CALCULATIONS
), CalculationsFetcherInterface {
    override suspend fun initialization(loan: LoanInitializationInterface): LoanDetails {
        return post("/v1/loan", loan)
    }
}
