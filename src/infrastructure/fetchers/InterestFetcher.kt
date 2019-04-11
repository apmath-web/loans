package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.InterestFetcherInterface

class InterestFetcher : InterestFetcherInterface {
    //no specification yet
    override suspend fun get(loan: Any): Int {
        TODO("not implemented")
    }
}
