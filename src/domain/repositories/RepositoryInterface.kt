package com.apmath.loans.domain.repositories

import com.apmath.loans.domain.models.LoanEmployeeInterface

//TODO replace with database
interface RepositoryInterface {
    fun get(id: Int): LoanEmployeeInterface
    fun store(loan: LoanEmployeeInterface)
    fun remove(loan: LoanEmployeeInterface)
}
