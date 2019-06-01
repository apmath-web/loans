package com.apmath.loans.application.v1.models.outgoing

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money

class ResponseLoan(
    var clientId: Int? = null,
    var applicationId: Int? = null,

    var amount: Money? = null,
    var term: Int? = null,
    var interest: Float? = null,
    var currency: Currency? = null,
    var date: String? = null,
    var completed: Boolean? = null,
    var rounding: Int? = null,
    var regularPaymentAmount: Money? = null,
    var remainingTerm: Int? = null
)
