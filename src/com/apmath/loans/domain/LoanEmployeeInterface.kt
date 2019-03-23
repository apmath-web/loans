package com.apmath.loans.domain

import com.apmath.loans.domain.data.Money

interface LoanEmployeeInterface : LoanClientInterface {
    //also LoanClientInterface here
    val rounding: Int
    val regularPaymentAmount: Money
    val remainBody: Money
    val remainingTerm: Int
    val completed: Boolean
}