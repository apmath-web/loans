package com.apmath.loans.infrastructure

import com.apmath.loans.domain.fetchers.*
import com.apmath.loans.domain.repositories.*
import com.apmath.loans.domain.services.*
import com.apmath.loans.infrastructure.fetchers.*
import io.ktor.config.ApplicationConfig
import io.ktor.util.KtorExperimentalAPI
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

@KtorExperimentalAPI
/**
 * Module in which services connect to their interfaces
 */
val loans = module {
    //services
    singleBy<LoanServiceInterface, LoanService>()
    //fetchers
    single {
        val config = getProperty<ApplicationConfig>("config")
        ApplicationsFetcher(
            config.property("applications.host").getString(),
            config.property("applications.port").getString().toInt()
        ) as ApplicationsFetcherInterface
    }
    single {
        val config = getProperty<ApplicationConfig>("config")
        CalculationsFetcher(
            config.property("calculations.host").getString(),
            config.property("calculations.port").getString().toInt()
        ) as CalculationsFetcherInterface
    }
    single {
        val config = getProperty<ApplicationConfig>("config")
        ClientsFetcher(
            config.property("clients.host").getString(),
            config.property("clients.port").getString().toInt()
        ) as ClientsFetcherInterface
    }
    //repositories
    singleBy<RepositoryInterface, Repository>()
}
