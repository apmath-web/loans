package com.apmath.loans.application.v1.exceptions

import com.apmath.validation.simple.MessageInterface
import com.apmath.validation.simple.ValidatorInterface

class BadRequestValidationException(validation: ValidatorInterface) : BadRequestException("Validation error") {
    val messages: MutableList<MessageInterface> = validation.messages
}
