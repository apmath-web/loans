package com.apmath.loans.domain.repositories

import com.apmath.loans.domain.exceptions.*
import com.apmath.loans.domain.exceptions.runtime.RemoveAbsentLoanException
import com.apmath.loans.domain.exceptions.runtime.RemoveUnidentifiedLoanException
import com.apmath.loans.domain.exceptions.runtime.StoreIdentifiedLoanException
import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.data.Type

class Repository : RepositoryInterface {
    private var identity: Int = 1
    private val loans: HashMap<Int, LoanInterface> = hashMapOf()

    override fun getAll():List<LoanInterface> = loans.toList().map { it.second }

    override fun get(id: Int): LoanInterface {
        return loans[id] ?: throw LoanNotFoundException()
    }

    override fun store(loan: LoanInterface) {
        if (loan.id != null) {
            throw StoreIdentifiedLoanException()
        }
        loan.id = identity
        loans[identity++] = loan
    }

    override fun remove(loan: LoanInterface) {
        when {
            loan.id == null                         -> throw RemoveUnidentifiedLoanException()
            !loan.completed                         -> throw RemoveUnfinishedLoanException()
            !this.loans.containsKey(loan.id as Int) -> throw RemoveAbsentLoanException()
        }

        this.loans.remove(loan.id)
    }

    override fun getListOfPayments(id: Int, type: Type?): List<PaymentFromCalculationInterface> {
        return loans[id]!!.getPayments(type)
    }
}
