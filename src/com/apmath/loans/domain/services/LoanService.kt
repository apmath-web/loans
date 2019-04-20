package com.apmath.loans.domain.services

import com.apmath.loans.domain.exceptions.AmountMoreThanMaxException
import com.apmath.loans.domain.exceptions.NoClientException
import com.apmath.loans.domain.exceptions.NotApprovedException
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
            val clientId = loan.clientId
            val applicationId = loan.applicationId

            val applicationResult = async {
                applicationsFetcher.getApplication(applicationId)
            }
            val clientResult = async {
                clientsFetcher.isExists(clientId)
            }
            val calculationResult = async(start = CoroutineStart.LAZY) {
                val loanInit = loan.toLoanInitialization(applicationResult.await())
                calculationsFetcher.initialization(loanInit)
            }

            when {
                !clientResult.await()
                                -> throw NoClientException(clientId)
                applicationResult.await().status != Status.APPROVED
                                -> throw NotApprovedException(applicationResult.await().status)
                applicationResult.await().maxAmount < loan.amount
                                -> throw AmountMoreThanMaxException(loan.amount, applicationResult.await().maxAmount)
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
