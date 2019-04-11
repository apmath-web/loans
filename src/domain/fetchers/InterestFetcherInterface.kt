package com.apmath.loans.domain.fetchers

interface InterestFetcherInterface {
    //TODO: no specification
    suspend fun get(loan: Any): Int
}
