package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.Loan

interface LoanServiceInterface {
    fun add(loan: Loan) : Int
}
