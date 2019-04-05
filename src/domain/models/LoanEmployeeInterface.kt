package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.PaymentInterface as RequestPaymentInterface
import com.apmath.loans.domain.models.calculation.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

interface LoanEmployeeInterface : LoanClientInterface {
    //also LoanClientInterface here
    val rounding: Int
    val regularPaymentAmount: Money
    val remainBody: Money
    val remainingTerm: Int

    fun getPayments(type: Type?): List<ResponsePaymentInterface>
    fun writeOf(paymentRequest: RequestPaymentInterface)
}
