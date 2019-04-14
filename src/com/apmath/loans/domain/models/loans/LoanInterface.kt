package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.calculation.response.PaymentFromCalculationInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.payments.PaymentInterface as RequestPaymentInterface

interface LoanInterface : LoanCreationDataInterface {
    //also LoanCreationDataInterface here
    var id: Int?

    val interest: Int
    val rounding: Int
    val regularPaymentAmount: Money
    val remainBody: Money
    val remainingTerm: Int
    val completed: Boolean

    //fun getPayments(type: Type?): List<ResponsePaymentInterface>
    //fun writeOf(paymentRequest: RequestPaymentInterface)
}
