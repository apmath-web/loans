package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.connections.response.PaymentInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

interface LoanEmployeeInterface : LoanClientInterface {
    //also LoanClientInterface here
    val rounding: Int
    val regularPaymentAmount: Money
    val remainBody: Money
    val remainingTerm: Int
    val completed: Boolean

    fun getPayments(type: Type?): List<PaymentInterface>
    fun writeOf(paymentRequest: com.apmath.loans.application.v1.models.PaymentInterface)
}