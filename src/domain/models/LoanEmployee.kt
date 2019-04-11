package domain.models

import com.apmath.loans.domain.models.LoanEmployeeInterface
import com.apmath.loans.domain.models.data.Currency
import domain.exceptions.runtime.ChangeIdentifiedCreditIdException
import com.apmath.loans.domain.models.PaymentInterface as RequestPaymentInterface
import com.apmath.loans.domain.models.calculation.response.PaymentInterface as ResponsePaymentInterface
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Type

class LoanEmployee(
    override val clientId: Int,
    override val applicationId: Int,

    override val amount: Money,
    override val term: Int,
    override val interest: Money,
    override val currency: Currency,
    override val date: String,

    override val rounding: Int,
    override val regularPaymentAmount: Money,
    override val remainBody: Money,
    override val remainingTerm: Int
) : LoanEmployeeInterface {
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
        TODO("not implemented")
    }

    override fun writeOf(paymentRequest: RequestPaymentInterface) {
        TODO("not implemented")
    }

}
