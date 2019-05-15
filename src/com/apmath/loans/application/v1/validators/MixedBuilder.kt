package com.apmath.loans.application.v1.validators

import com.apmath.validation.builders.ObjectValidatorBuilder
import com.apmath.validation.simple.ComparableValidator

class MixedBuilder : ObjectValidatorBuilder() {
    init {
        append("clientIdHeader", ComparableValidator(min = 1))
        append("clientId", ComparableValidator(min = 1))
    }
}
