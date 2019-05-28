package com.apmath.loans.domain.models

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import com.apmath.loans.domain.data.Status

interface ApplicationInterface {
    val amount: Money
    val currency: Currency
    val term: Int
}
