package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

class Loan {
    var applicationId: Int? = null
    var amount: Money? = null
    var currency: Currency? = null
    var term: Int? = null
    var date: String? = null
}
