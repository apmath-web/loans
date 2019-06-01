package com.apmath.loans.infrastructure.fetchers

import com.apmath.loans.domain.fetchers.CalculationsFetcherInterface
import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanInitializationInterface
import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.infrastructure.models.NextCalculationsPayment
import com.apmath.loans.infrastructure.models.ResultCalculationsPayment
import com.apmath.loans.infrastructure.models.loans.LoanDetails
import com.apmath.loans.infrastructure.models.loans.LoanForCalculations
import com.apmath.loans.infrastructure.models.payments.PaymentDate
import com.apmath.loans.infrastructure.models.payments.PaymentLast

class CalculationsFetcher(
    host: String,
    port: Int
) : AbstractFetcher(host, port), CalculationsFetcherInterface {
    override suspend fun initialization(loan: LoanInitializationInterface): LoanDetails {
        return post("/v1/loan", loan)
    }
    override suspend fun nextNewPayment(payment: PaymentInterface, loan: LoanInterface): ResultCalculationsPayment {
        val paymentData = getFirstCalculationsPayment(payment, loan)
        return post("/v1/payment", paymentData)
    }

    override suspend fun nextPayment(payment: PaymentInterface, loan: LoanInterface, lastPayment: PaymentFromCalculationInterface): ResultCalculationsPayment {
        val paymentData = getNextCalculationsPayment(payment, loan, lastPayment)
        return put("/v1/payment", paymentData)
    }

    fun getFirstCalculationsPayment(
        payment: PaymentInterface,
        loan: LoanInterface
    ): NextCalculationsPaymentInterface {

        val loan = LoanForCalculations(
            loan.amount,
            loan.term,
            loan.interest,
            loan.date,
            null,
            loan.rounding,
            loan.regularPaymentAmount
        )

        val paymentDate = PaymentDate(
            payment.date,
            payment.payment
        )

        return NextCalculationsPayment(loan, paymentDate, null)

    }

    fun getNextCalculationsPayment(
        payment: PaymentInterface,
        loan: LoanInterface,
        lastPayment: PaymentFromCalculationInterface
    ): NextCalculationsPaymentInterface {

        val loan = LoanForCalculations(
            null,
            null,
            loan.interest,
            loan.date,
            loan.remainingTerm,
            loan.rounding,
            loan.regularPaymentAmount
        )

        val payment = PaymentDate(
            payment.date,
            payment.payment
        )

        val lastPayment = PaymentLast(
            lastPayment.date,
            lastPayment.amount,
            lastPayment.remainCreditBody
        )

        return NextCalculationsPayment(loan, payment, lastPayment)

    }

}
