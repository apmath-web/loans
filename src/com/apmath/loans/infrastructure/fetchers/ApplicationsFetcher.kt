package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.infrastructure.aplications.response.Application

class ApplicationsFetcher : AbstractFetcher(
    Host.APPLICATIONS,
    true
), ApplicationsFetcherInterface {
    override suspend fun getApplication(applicationId: Int): Application {
        return get("/v1/$applicationId")
    }
}
