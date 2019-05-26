package com.apmath.loans.domain.services

import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.domain.repositories.RepositoryInterface

class PaymentService(
    private val calculationsFetcher: CalculationsFetcherInterface,
    private val repository: RepositoryInterface
) : PaymentServiceInterface {
    override suspend fun add(payment: PaymentInterface, loanId: Int, clientId: Int): String {
        //TODO("not implemented")
        return "2019-03-09"
    }

}
