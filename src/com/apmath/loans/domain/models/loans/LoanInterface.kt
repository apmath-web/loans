package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface as ResponsePaymentInterface

interface LoanInterface : LoanCreationDataInterface {
    //also LoanCreationDataInterface here
    var id: Int?

    val interest: Int
    val rounding: Int
    val regularPaymentAmount: Money
    val remainingTerm: Int
    val completed: Boolean

    fun getPayments(type: Type?): List<ResponsePaymentInterface>
    fun writeOf(payment: ResponsePaymentInterface)
}
