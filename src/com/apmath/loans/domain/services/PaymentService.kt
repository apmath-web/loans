package com.apmath.loans.domain.services

import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.domain.models.payments.Payment
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.repositories.RepositoryInterface
import com.apmath.loans.infrastructure.models.payments.PaymentFromCalculation

class PaymentService(
    private val repository: RepositoryInterface
) : PaymentServiceInterface {
    override suspend fun get(loanIdHeader: Int?, loanId: Int): List<PaymentFromCalculationInterface> {

        val results: List<PaymentFromCalculationInterface> = repository.getListOfPayments(loanId, null)

        return results
    }
}
