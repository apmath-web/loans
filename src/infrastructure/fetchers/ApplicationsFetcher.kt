package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.domain.models.application.response.ApplicationInterface
import com.apmath.loans.domain.models.data.Status

class ApplicationsFetcher : ApplicationsFetcherInterface {
    override suspend fun getApplication(applicationId: Int): ApplicationInterface {
        TODO("not implemented")
    }

    override suspend fun isApproved(applicationId: Int): Boolean {
        return getApplication(applicationId).status == Status.APPROVED
    }
}
