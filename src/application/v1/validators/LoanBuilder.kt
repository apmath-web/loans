package com.apmath.loans.application.v1.validators

import com.apmath.validation.builders.ObjectValidatorBuilder
import com.apmath.validation.simple.ComparableValidator
import com.apmath.validation.simple.DateValidator
import com.apmath.validation.simple.RangeValidator
import com.apmath.validation.simple.RegexValidator

class LoanBuilder : ObjectValidatorBuilder() {
    init {
        append("clientId", ComparableValidator(min = 1))
        append("applicationId", ComparableValidator(min = 1))
        append("amount", ComparableValidator(min = 1L, max = 3000000000000000L))
        append("currency", RegexValidator("\\b[A-Z]{3}\\b"))//TODO: rework with possible currency
        append("term", ComparableValidator(min = 6, max = 1200))
        append("date", DateValidator())
    }
}