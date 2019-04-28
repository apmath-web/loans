package com.apmath.loans.domain.models

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Status

interface ApplicationInterface {
    val amount: Money
    val currency: Currency
    val period: Int
    val status: Status

    val clientId: Int
    val interest: Int
    val maxAmount: Money
    val minAmount: Money
}
