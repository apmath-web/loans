package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.Loan
import com.apmath.loans.infrastructure.connections.ServiceManager
import com.apmath.loans.infrastructure.fetchers.ApplicationsFetcher
import com.apmath.loans.infrastructure.fetchers.CalculationFetcher
import com.apmath.loans.infrastructure.fetchers.ClientsFetcher
import com.apmath.loans.infrastructure.fetchers.InterestFetcher
import domain.models.LoanEmployee
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class LoanService(
    private val applicationsFetcher: ApplicationsFetcher,
    private val calculationFetcher: CalculationFetcher,
    private val clientsFetcher: ClientsFetcher,
    private val interestFetcher: InterestFetcher
) : LoanServiceInterface {
    override fun add(loan: Loan): Int {
        return runBlocking {
            val applicationResult = async {
                applicationsFetcher.isApproved(loan.applicationId)
            }
            val clientResult = async {
                clientsFetcher.isExists(loan.clientId)
            }
            val calculationResult = async(start = CoroutineStart.LAZY) {
                calculationFetcher.initialization(loan)
            }
            val interestResult = async(start = CoroutineStart.LAZY) {
                interestFetcher.get(loan)
            }

            if (applicationResult.await() && clientResult.await()) {
                //freeze check-cor until data is correct
                val loanDetails = calculationResult.await()
                val interest = interestResult.await()

                val loanEmployee = LoanEmployee(
                    loan.clientId,
                    loan.applicationId,
                    loan.amount,
                    loan.term,
                    interest,
                    loan.currency,
                    loan.date,
                    loanDetails.rounding,
                    loanDetails.regularPaymentAmount,
                    loan.amount,
                    loan.term
                )

                ServiceManager.instance.repository.store(loanEmployee)
                return@runBlocking loanEmployee.id!!
            } else {
                applicationResult.cancel()
                clientResult.cancel()
                throw Exception()//TODO
            }
        }
    }
}
