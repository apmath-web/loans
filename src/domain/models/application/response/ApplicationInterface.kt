package com.apmath.loans.domain.models.application.response

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Status

interface ApplicationInterface {
    val amount: Money
    val currency: Currency
    val period: Int
    val status: Status
}
