package com.apmath.loans.application.v1.validators

import com.apmath.validation.builders.ObjectValidatorBuilder
import com.apmath.validation.simple.ComparableValidator
import com.apmath.validation.simple.RegexValidator

class MixedLoanBuilder : ObjectValidatorBuilder() {
    init {
        val onlyNumber = "\\d*[1-9]\\d*"

        append("loanIdHeader", ComparableValidator(min = 1))
        append("loanId", RegexValidator(onlyNumber))
    }
}
