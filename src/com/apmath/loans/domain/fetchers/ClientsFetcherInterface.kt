package com.apmath.loans.domain.fetchers

import com.apmath.loans.application.v1.models.incoming.Info

interface ClientsFetcherInterface {
    suspend fun isExists(clientId: Int): Boolean
    suspend fun getInfo(): Info
}
