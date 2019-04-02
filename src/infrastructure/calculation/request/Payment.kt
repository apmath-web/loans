package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.PaymentInterface

class Payment(override val date: String) : PaymentInterface
