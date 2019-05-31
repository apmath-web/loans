package com.apmath.loans.domain.models.mappers

import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.infrastructure.models.NextCalculationsPayment
import com.apmath.loans.infrastructure.models.loans.LoanForCalculations
import com.apmath.loans.infrastructure.models.payments.PaymentDate
import com.apmath.loans.infrastructure.models.payments.PaymentLast

fun getFirstCalculationsPayment(
    payment: PaymentInterface,
    loan: LoanInterface
): NextCalculationsPaymentInterface {

    val loan = LoanForCalculations(
        loan.amount,
        loan.term,
        loan.interest.toInt(),
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
        loan.interest.toInt(),
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
