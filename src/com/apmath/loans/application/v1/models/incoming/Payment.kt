package com.apmath.loans.application.v1.models.incoming

import com.apmath.loans.domain.data.Currency
import com.apmath.loans.domain.data.Money
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.apmath.loans.domain.models.payments.Payment as PaymentDomain

class Payment {
    var payment: Money? = null
    var currency: Currency? = null
    var date: String? = null
    var clientId: Int? = null
    var loanId: String? = null
}

fun Payment.toPaymentDomain() = PaymentDomain(
    payment!!,
    currency!!,
    if (date == null) {
        LocalDate.now()
    } else {
        LocalDate.parse(date, DateTimeFormatter.ISO_DATE)
    }
)
