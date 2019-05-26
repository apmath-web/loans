package com.apmath.loans.domain.repositories

import com.apmath.loans.domain.models.loans.LoanInterface
import com.apmath.loans.domain.models.payments.PaymentFromCalculationInterface
import com.apmath.loans.domain.data.Type

//TODO replace with database
interface RepositoryInterface {
    fun get(id: Int): LoanInterface
    fun getAll(): List<LoanInterface>
    fun store(loan: LoanInterface)
    fun remove(loan: LoanInterface)
    fun getListOfPayments(id: Int, type: Type?): List<PaymentFromCalculationInterface>
}
