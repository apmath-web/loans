package com.apmath.loans.domain.services

import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.exceptions.LoanCompletedException
import com.apmath.loans.domain.exceptions.ForeignClientIdException
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.domain.repositories.RepositoryInterface
import com.apmath.loans.infrastructure.models.payments.PaymentFromCalculation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.time.LocalDate

class PaymentService(
    private val calculationsFetcher: CalculationsFetcherInterface,
    private val repository: RepositoryInterface
) : PaymentServiceInterface {
    override suspend fun get(loanId: Int, clientId: Int?): Array<PaymentFromCalculationInterface> {
        // for manual testing
        val payment = PaymentFromCalculation(
            LocalDate.now(),
            1,
            2,
            3,
            Type.REGULAR,
            4,
            5
        )
        return arrayOf(payment)
    }
    override suspend fun add(payment: PaymentInterface, loanId: Int, clientId: Int?): LocalDate {
        //TODO("not implemented")
        val loan = repository.get(loanId)

        if (loan.clientId != clientId) {
            throw ForeignClientIdException()
        }

        if (loan.completed) {
            throw LoanCompletedException()
        }

        val asyncPayment = GlobalScope.async {
            val isFirstPay = loan.getPayments().isEmpty()

            if (isFirstPay) {
                calculationsFetcher.nextNewPayment(payment,loan)
            } else {
                val lastPayment = loan.getPayments().last()
                calculationsFetcher.nextPayment(payment, loan, lastPayment)
            }
        }

        val resultPayment = asyncPayment.await()

        return loan.writeOf(resultPayment)
    }
}
