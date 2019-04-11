package com.apmath.loans.infrastructure.connections

import com.apmath.loans.domain.repositories.Repository
import com.apmath.loans.domain.repositories.RepositoryInterface
import com.apmath.loans.domain.services.LoanService
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.loans.infrastructure.fetchers.ApplicationsFetcher
import com.apmath.loans.infrastructure.fetchers.CalculationFetcher
import com.apmath.loans.infrastructure.fetchers.ClientsFetcher
import com.apmath.loans.infrastructure.fetchers.InterestFetcher

//TODO: temporary implementation
class ServiceManager {

    //temporary repository
    val repository: RepositoryInterface = Repository()

    fun getLoanService(): LoanServiceInterface {
        //init fetchers
        val applicationsFetcher = ApplicationsFetcher()
        val calculationFetcher = CalculationFetcher()
        val clientsFetcher = ClientsFetcher()
        val interestFetcher = InterestFetcher()

        //return interface implementation
        return LoanService(applicationsFetcher, calculationFetcher, clientsFetcher, interestFetcher)
    }

    companion object {
        val instance = ServiceManager()
    }
}
