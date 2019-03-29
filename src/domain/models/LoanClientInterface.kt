package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.connections.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

interface LoanClientInterface {
    var id: Int?
    val isFinished: Boolean

    val amount: Money
    val term: Int
    val interest: Money
    val date: String

    fun getPayments(type: Type?): List<ResponsePaymentInterface>
    //fun writeOf(paymentRequest: PaymentInterface)
}
