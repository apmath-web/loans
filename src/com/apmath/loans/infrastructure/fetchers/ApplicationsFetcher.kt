package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.application.v1.models.incoming.Info
import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.domain.models.ApplicationInterface
import com.apmath.loans.infrastructure.models.ApplicationDetails

class ApplicationsFetcher(
    host: String,
    port: Int
) : AbstractFetcher(host, port), ApplicationsFetcherInterface {
    override suspend fun getInfo(): Info {
        return get("/v1/info")
    }

    override suspend fun getApplication(
        clientId: Int,
        applicationId: Int,
        application: ApplicationInterface
    ): ApplicationDetails {
        println("$host:$port/v1/$clientId/$applicationId")
        println(application)
        return post("/v1/$clientId/$applicationId", application)
    }
}
