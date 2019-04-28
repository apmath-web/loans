package com.apmath.loans.infrastructure

import com.apmath.loans.domain.fetchers.*
import com.apmath.loans.domain.repositories.*
import com.apmath.loans.domain.services.*
import com.apmath.loans.infrastructure.fetchers.*
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

/**
 * Module in which services connect to their interfaces
 */
val loans = module {
    //services
    singleBy<LoanServiceInterface, LoanService>()
    //fetchers
    singleBy<ApplicationsFetcherInterface, ApplicationsFetcher>()
    singleBy<CalculationsFetcherInterface, CalculationsFetcher>()
    singleBy<ClientsFetcherInterface, ClientsFetcher>()
    //repositories
    singleBy<RepositoryInterface, Repository>()
}
