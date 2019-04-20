package com.apmath.loans.domain.services

import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.fetchers.ClientsFetcherInterface
import com.apmath.loans.domain.models.data.Status
import com.apmath.loans.domain.models.loans.LoanCreationDataInterface
import com.apmath.loans.domain.models.loans.toLoan
import com.apmath.loans.domain.models.loans.toLoanInitialization
import com.apmath.loans.domain.repositories.RepositoryInterface
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class LoanService(
    private val applicationsFetcher: ApplicationsFetcherInterface,
    private val calculationsFetcher: CalculationsFetcherInterface,
    private val clientsFetcher: ClientsFetcherInterface,
    private val repository: RepositoryInterface
) : LoanServiceInterface {
    override fun add(loan: LoanCreationDataInterface): Int {
        return runBlocking {
            val applicationResult = async {
                applicationsFetcher.getApplication(loan.applicationId)
            }
            val clientResult = async {
                clientsFetcher.isExists(loan.clientId)
            }
            val calculationResult = async(start = CoroutineStart.LAZY) {
                val loanInit = loan.toLoanInitialization(applicationResult.await())
                calculationsFetcher.initialization(loanInit)
            }

            when {
                !clientResult.await()                               -> throw Exception()
                applicationResult.await().status != Status.APPROVED -> throw Exception("1")
                applicationResult.await().maxAmount < loan.amount   -> throw Exception("2")
                else -> {
                    val loanDetails = calculationResult.await()
                    val interest = applicationResult.await().interest

                    val loanEmployee = loan.toLoan(interest, loanDetails)

                    repository.store(loanEmployee)
                    return@runBlocking loanEmployee.id!!
                }
            }
        }
    }
}
