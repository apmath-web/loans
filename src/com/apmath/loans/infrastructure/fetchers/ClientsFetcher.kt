package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.ClientsFetcherInterface

class ClientsFetcher : ClientsFetcherInterface {
    override suspend fun isExists(clientId: Int): Boolean {
        TODO("not implemented")
    }
}
