package com.apmath.loans.domain.models

import com.apmath.loans.domain.exceptions.runtime.ChangeIdentifiedCreditIdException
import com.apmath.loans.application.v1.models.PaymentInterface as RequestPaymentInterface
import com.apmath.loans.domain.models.connections.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

class LoanEmployee(
    override val rounding: Int,
    override val regularPaymentAmount: Money,
    override val remainBody: Money,
    override val remainingTerm: Int,
    override val completed: Boolean,
    override val amount: Money,
    override val term: Int,
    override val interest: Money,
    override val date: String
) : LoanEmployeeInterface {
    override var id: Int? = null
        set(value) {
            if (field == null) {
                field = value
            } else {
                throw ChangeIdentifiedCreditIdException()
            }
        }

    override var isFinished: Boolean = false
        private set

    private val payments: MutableList<ResponsePaymentInterface> = arrayListOf()

    override fun getPayments(type: Type?): List<ResponsePaymentInterface> {
        TODO("not implemented")
    }

    override fun writeOf(paymentRequest: RequestPaymentInterface) {
        TODO("not implemented")
    }

}
