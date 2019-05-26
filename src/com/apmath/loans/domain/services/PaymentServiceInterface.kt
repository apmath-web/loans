package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.payments.PaymentInterface

interface PaymentServiceInterface {
    suspend fun add(payment: PaymentInterface, loanId: Int, clientId: Int) : String
}
