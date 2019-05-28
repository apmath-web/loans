package com.apmath.loans.domain.services

import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.domain.models.payments.Payment
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.repositories.RepositoryInterface
import com.apmath.loans.infrastructure.models.payments.PaymentFromCalculation

class PaymentService(
    private val calculationsFetcher: CalculationsFetcherInterface,
    private val repository: RepositoryInterface
) : PaymentServiceInterface {
    override suspend fun get(loanIdHeader: Int?, loanId: Int?): Array<PaymentFromCalculationInterface> {
        // for manual testing
        val payment = PaymentFromCalculation(
            "date",
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
