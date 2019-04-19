package com.apmath.loans.domain.fetchers

interface ClientsFetcherInterface {
    suspend fun isExists(clientId: Int): Boolean
}
