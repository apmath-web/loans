package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.application.v1.models.incoming.Info
import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanInitializationInterface
import com.apmath.loans.infrastructure.models.ResultCalculationsPayment
import com.apmath.loans.infrastructure.models.loans.LoanDetails

class CalculationsFetcher(
    host: String,
    port: Int
) : AbstractFetcher(host, port), CalculationsFetcherInterface {
    override suspend fun getInfo(): Info {
        return get("/v1/info")
    }

    override suspend fun initialization(loan: LoanInitializationInterface): LoanDetails {
        return post("/v1/loan", loan)
    }

    override suspend fun nextNewPayment(paymentData: NextCalculationsPaymentInterface): ResultCalculationsPayment {
        return post("/v1/payment", paymentData)
    }

    override suspend fun nextPayment(paymentData: NextCalculationsPaymentInterface): ResultCalculationsPayment {
        return put("/v1/payment", paymentData)
    }
}
