package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.loans.LoanCreationDataInterface

interface LoanServiceInterface {
    suspend fun add(loan: LoanCreationDataInterface) : Int
}
