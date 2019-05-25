package com.apmath.loans.domain.fetchers

import com.apmath.loans.domain.models.ApplicationInterface

interface ApplicationsFetcherInterface {
    suspend fun getApplication(clientId: Int, applicationId: Int): ApplicationInterface
}
