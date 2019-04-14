package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.calculation.response.PaymentFromCalculationInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money

interface LoanCreationDataInterface {
    val clientId: Int
    val applicationId: Int

    val amount: Money
    val currency: Currency
    val term: Int
    val date: String
}
