package com.apmath.loans.domain

interface RepositoryInterface {
    fun get(id: Int): LoanEmployeeInterface
    fun store(credit: LoanEmployeeInterface)
    fun remove(credit: LoanEmployeeInterface)
}
