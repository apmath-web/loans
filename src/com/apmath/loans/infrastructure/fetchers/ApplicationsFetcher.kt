package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.domain.models.ApplicationInterface
import com.apmath.loans.domain.models.data.Status

class ApplicationsFetcher : AbstractFetcher(
    Host.APPLICATIONS,
    true
), ApplicationsFetcherInterface {
    override suspend fun getApplication(applicationId: Int): ApplicationInterface {
        return get("/v1/$applicationId")
    }

    override suspend fun isApproved(applicationId: Int): Boolean {
        return getApplication(applicationId).status == Status.APPROVED
    }
}
