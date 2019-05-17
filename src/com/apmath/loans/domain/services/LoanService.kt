package com.apmath.loans.domain.services

import com.apmath.loans.domain.data.Status
import com.apmath.loans.domain.exceptions.*
import com.apmath.loans.domain.fetchers.ApplicationsFetcherInterface
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.fetchers.ClientsFetcherInterface
import com.apmath.loans.domain.models.MixedIdInterface
import com.apmath.loans.domain.models.loans.LoanCreationDataInterface
import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.loans.toLoan
import com.apmath.loans.domain.models.loans.toLoanInitialization
import com.apmath.loans.domain.repositories.RepositoryInterface
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LoanService(
    private val applicationsFetcher: ApplicationsFetcherInterface,
    private val calculationsFetcher: CalculationsFetcherInterface,
    private val clientsFetcher: ClientsFetcherInterface,
    private val repository: RepositoryInterface
) : LoanServiceInterface {
    //TODO: may need to replace GlobalScope.async
    override suspend fun add(loan: LoanCreationDataInterface): Int {
        val clientId = loan.clientId
        val applicationId = loan.applicationId

        val applicationResult = GlobalScope.async {
            applicationsFetcher.getApplication(applicationId)
        }
        val clientResult = GlobalScope.async {
            clientsFetcher.isExists(clientId)
        }
        val calculationResult = GlobalScope.async(start = CoroutineStart.LAZY) {
            val loanInit = loan.toLoanInitialization(applicationResult.await())
            calculationsFetcher.initialization(loanInit)
        }

        val application = applicationResult.await()
        val loanDetails = calculationResult.await()
        val client = clientResult.await()

        when {
            //client does not exists
            !client
            -> throw NoClientException()
            //application status is not approved
            application.status != Status.APPROVED
            -> throw NotApprovedException(application.status)
            //application's client is not our client
            application.clientId != clientId
            -> throw WrongClientId()
            //amount must be in bounds
            loan.amount > application.maxAmount || loan.amount < application.minAmount
            -> throw WrongAmountException(application.minAmount, application.maxAmount)

            else -> {
                val interest = application.interest

                val loanEmployee = loan.toLoan(interest, loanDetails)

                repository.store(loanEmployee)
                return loanEmployee.id!!
            }
        }
    }

    override suspend fun get(isService: Boolean, clientIdHeader: Int?, clientId: Int?): Array<LoanInterface> {
        val loans: List<LoanInterface> = repository.getAll()
        val results: MutableList<LoanInterface> = arrayListOf()

        when {
            //if it's service
            isService               -> results.addAll(loans.filter { it.clientId == clientId })
            //if it's client
            clientIdHeader != null  -> {
                if (clientIdHeader != clientId) {
                    throw ForbiddenAccessException()
                }
                results.addAll(loans.filter { it.clientId == clientId })
            }
            //if trying to get client without header
            clientId != null        -> throw ForbiddenAccessException()
        }

        return results.toTypedArray()
    }
}
