package com.apmath.loans.domain.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money
import com.apmath.loans.domain.models.data.Status

interface ApplicationInterface {
    val amount: Money
    val currency: Currency
    val period: Int
    val status: Status

    //TODO: Not implemented in specification yet, but must be
    val interest: Int
    val maxAmount: Money
}
