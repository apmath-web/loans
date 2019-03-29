package com.apmath.loans.domain.repositories

import com.apmath.loans.domain.models.LoanEmployeeInterface

interface RepositoryInterface {
    fun get(id: Int): LoanEmployeeInterface
    fun store(credit: LoanEmployeeInterface)
    fun remove(credit: LoanEmployeeInterface)
}
