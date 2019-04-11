package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.LoanClient

interface LoanServiceInterface {
    fun add(loan: LoanClient) : Int
}
