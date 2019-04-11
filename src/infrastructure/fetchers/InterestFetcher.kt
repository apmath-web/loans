package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.InterestFetcherInterface

class InterestFetcher : InterestFetcherInterface {
    override suspend fun get(loan: Any): Int {
        TODO("not implemented")
    }
}
