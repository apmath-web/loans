package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

class Payment {
    var payment: Money? = null
    var currency: Currency? = null
    var date: String? = null
}
