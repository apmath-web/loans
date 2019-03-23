package com.apmath.loans.domain.models

interface RepositoryInterface {
    fun get(id: Int): LoanEmployeeInterface
    fun store(credit: LoanEmployeeInterface)
    fun remove(credit: LoanEmployeeInterface)
}
