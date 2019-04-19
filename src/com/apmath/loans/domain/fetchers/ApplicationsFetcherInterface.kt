package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.ApplicationInterface

interface ApplicationsFetcherInterface {
    suspend fun isApproved(applicationId: Int): Boolean
    suspend fun getApplication(applicationId: Int): ApplicationInterface
}
