package com.apmath.loans.domain.repositories

import com.apmath.loans.domain.exceptions.*
import com.apmath.loans.domain.exceptions.runtime.RemoveAbsentLoanException
import com.apmath.loans.domain.exceptions.runtime.RemoveUnidentifiedLoanException
import com.apmath.loans.domain.exceptions.runtime.StoreIdentifiedLoanException
import com.apmath.loans.domain.models.LoanEmployeeInterface

class Repository : RepositoryInterface {
    private val identity: Int = 1
    private val loans: HashMap<Int, LoanEmployeeInterface> = hashMapOf()

    override fun get(id: Int): LoanEmployeeInterface {
        return loans[id] ?: throw LoanNotFoundException()
    }

    override fun store(loan: LoanEmployeeInterface) {
        if (loan.id != null) {
            throw StoreIdentifiedLoanException()
        }
        loan.id = identity
        loans[identity++] = loan
    }

    override fun remove(loan: LoanEmployeeInterface) {
        when {
            loan.id == null                         -> throw RemoveUnidentifiedLoanException()
            !loan.isFinished                        -> throw RemoveUnfinishedLoanException()
            !this.loans.containsKey(loan.id as Int)  -> throw RemoveAbsentLoanException()
        }

        this.loans.remove(loan.id)
    }

}
