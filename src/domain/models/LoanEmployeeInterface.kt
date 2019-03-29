package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Money

interface LoanEmployeeInterface : LoanClientInterface {
    //also LoanClientInterface here
    val rounding: Int
    val regularPaymentAmount: Money
    val remainBody: Money
    val remainingTerm: Int
    val completed: Boolean
}
