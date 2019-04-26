package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.exceptions.runtime.ChangeIdentifiedCreditIdException
import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Type
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface as ResponsePaymentInterface

class Loan(
    override val clientId: Int,
    override val applicationId: Int,

    override val amount: Money,
    override val term: Int,
    override val interest: Int,
    override val currency: Currency,
    override val date: String,

    override val rounding: Int,
    override val regularPaymentAmount: Money,
    override val remainingTerm: Int
) : LoanInterface {
    override var id: Int? = null
        set(value) {
            if (field == null) {
                field = value
            } else {
                throw ChangeIdentifiedCreditIdException()
            }
        }

    override var completed: Boolean = false
        private set

    private val payments: MutableList<ResponsePaymentInterface> = arrayListOf()

    override fun getPayments(type: Type?): List<ResponsePaymentInterface> {
        val results = arrayListOf<ResponsePaymentInterface>()

        return if (type == null)
            payments
        else {
            results.addAll(payments.filter { it.type == type })
            results
        }
    }

    override fun writeOf(payment: ResponsePaymentInterface) {
        payments.add(payment)
    }
}
