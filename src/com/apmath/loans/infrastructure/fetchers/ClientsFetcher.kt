package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.ClientsFetcherInterface
import io.ktor.client.response.HttpResponse
import io.ktor.http.isSuccess

class ClientsFetcher(
    host: String,
    port: Int
) : AbstractFetcher(host, port), ClientsFetcherInterface {
    override suspend fun isExists(clientId: Int): Boolean {
        return get<HttpResponse>("/v1/$clientId")
            .status.isSuccess()
    }
}
