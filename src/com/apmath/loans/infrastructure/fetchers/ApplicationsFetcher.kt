package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.infrastructure.models.Application

class ApplicationsFetcher(host: String, port: Int) : AbstractFetcher(host, port), ApplicationsFetcherInterface {
    override suspend fun getApplication(applicationId: Int): Application {
        return get("/v1/$applicationId")
    }
}
