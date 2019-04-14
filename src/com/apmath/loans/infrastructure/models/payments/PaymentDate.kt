package com.apmath.loans.infrastructure.calculation.request

import com.apmath.loans.domain.models.calculation.request.PaymentDateInterface

class PaymentDate(override val date: String) : PaymentDateInterface
