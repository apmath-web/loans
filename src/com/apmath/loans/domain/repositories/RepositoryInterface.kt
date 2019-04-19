package com.apmath.loans.domain.repositories

import com.apmath.loans.domain.models.loans.LoanInterface

//TODO replace with database
interface RepositoryInterface {
    fun get(id: Int): LoanInterface
    fun store(loan: LoanInterface)
    fun remove(loan: LoanInterface)
}
