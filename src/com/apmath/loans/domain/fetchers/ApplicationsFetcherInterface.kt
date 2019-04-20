package com.apmath.loans.domain.fetchers

import com.apmath.loans.infrastructure.aplications.response.Application

interface ApplicationsFetcherInterface {
    suspend fun getApplication(applicationId: Int): Application
}
