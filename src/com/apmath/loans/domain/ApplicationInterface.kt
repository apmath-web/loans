package com.apmath.loans.domain

import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Status
import java.util.Currency

interface ApplicationInterface {
    val amount: Money
    val currency: Currency
    val period: Int
    val status: Status
}
