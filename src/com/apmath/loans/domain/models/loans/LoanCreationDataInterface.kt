package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface as ResponsePaymentInterface

interface LoanCreationDataInterface {
    val clientId: Int
    val applicationId: Int

    val amount: Money
    val currency: Currency
    val term: Int
    val date: String
}
