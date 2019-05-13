package com.apmath.loans.domain.models

interface MixedLoanIdInterface {
    val isClient: Boolean
    val loanIdHeader: Int?
    val loanId: Int?
}