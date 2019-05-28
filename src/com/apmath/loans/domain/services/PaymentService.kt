package com.apmath.loans.domain.services

import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.mappers.getFirstCalculationsPayment
import com.apmath.loans.domain.models.mappers.getNextCalculationsPayment
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
    override suspend fun add(payment: PaymentInterface, loanId: Int, clientId: Int) : LocalDate {

        val loan = repository.get(loanId)

        val asyncPayment = GlobalScope.async {
            val isFirstPay = loan.getPayments().isEmpty()

            if (isFirstPay) {
                val calculationsPayment
                        = getFirstCalculationsPayment(payment,loan)
                calculationsFetcher.nextNewPayment(calculationsPayment)
            } else {
                val lastPayment = loan.getPayments().last()

                val calculationsPayment
                        = getNextCalculationsPayment(payment, loan, lastPayment)
                calculationsFetcher.nextPayment(calculationsPayment)
            }
        }

        val resultPayment = asyncPayment.await()

        when {

            loan.clientId != clientId -> throw Exception()

            loan.completed -> throw Exception()

            else -> {
                val loanDetails = resultPayment.loan
                val paymentFromCalculation = resultPayment.payment

                loan.writeOf(paymentFromCalculation)
                loan.regularPaymentAmount = loanDetails.regularPaymentAmount

                if (loanDetails.remainingTerm == 0) {
                    loan.completed = true
                }

                return paymentFromCalculation.date
            }

        }
    }
    override suspend fun get(loanIdHeader: Int?, loanId: Int?): Array<PaymentFromCalculationInterface> {
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
}
