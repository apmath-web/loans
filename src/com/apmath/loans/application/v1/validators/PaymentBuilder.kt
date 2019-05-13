package com.apmath.loans.application.v1.validators

import com.apmath.validation.builders.ObjectValidatorBuilder
import com.apmath.validation.simple.ComparableValidator
import com.apmath.validation.simple.DateValidator
import com.apmath.validation.simple.RegexValidator

class PaymentBuilder : ObjectValidatorBuilder() {
    init {
        append("payment", ComparableValidator(min = 1L, max = 3000000000000000L))
        append("currency", RegexValidator("\\b[A-Z]{3}\\b"))
        append("date", DateValidator())
        append("clientId", ComparableValidator(min = 1))
    }
}
