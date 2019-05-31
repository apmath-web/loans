package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.ApplicationDetailsInterface
import com.apmath.loans.infrastructure.models.Application
import com.apmath.loans.infrastructure.models.loans.LoanInitialization

data class LoanCreationData(
    override val clientId: Int,
    override val applicationId: Int,

    override val amount: Money,
    override val term: Int,
    override val currency: Currency,
    override val date: String
) : LoanCreationDataInterface

fun LoanCreationDataInterface.toLoan(interest: Float, term: Int, loanDetails: LoanDetailsInterface) = Loan(
    clientId,
    applicationId,
    amount,
    term,
    interest,
    currency,
    date,
    loanDetails.rounding,
    loanDetails.regularPaymentAmount,
    term
)

fun LoanCreationDataInterface.toLoanInitialization(application: ApplicationDetailsInterface) = LoanInitialization(
    amount = amount,
    term = term,
    interest = application.interest,
    date = date
)

fun LoanCreationDataInterface.toApplication() = Application(
    amount,
    currency,
    term
)
