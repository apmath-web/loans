package com.apmath.loans.domain.models.mappers

import com.apmath.loans.domain.models.NextCalculationsPaymentInterface
import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.models.payments.PaymentInterface
import com.apmath.loans.infrastructure.models.NextCalculationsPayment
import com.apmath.loans.infrastructure.models.loans.LoanForCalculations
import com.apmath.loans.infrastructure.models.payments.PaymentDate
import com.apmath.loans.infrastructure.models.payments.PaymentLast
import java.time.format.DateTimeFormatter

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
        payment.date.format(DateTimeFormatter.ISO_DATE),
        payment.payment
    )

    return NextCalculationsPayment(loan, paymentDate, null)

}

fun getNextCalculationsPayment(
    payment: PaymentInterface,
    loan: LoanInterface,
    lastPayment: PaymentFromCalculationInterface
): NextCalculationsPaymentInterface {

    val loanForCalc = LoanForCalculations(
        null,
        null,
        loan.interest,
        loan.date,
        loan.remainingTerm,
        loan.rounding,
        loan.regularPaymentAmount
    )

    val paymentForCalc = PaymentDate(
        payment.date.format(DateTimeFormatter.ISO_DATE),
        payment.payment
    )

    val lastPaymentForCalc = PaymentLast(
        lastPayment.date.format(DateTimeFormatter.ISO_DATE),
        lastPayment.amount,
        lastPayment.remainCreditBody
    )

    return NextCalculationsPayment(loanForCalc, paymentForCalc, lastPaymentForCalc)

}
