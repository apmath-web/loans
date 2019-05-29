package com.apmath.loans.infrastructure.models

import com.apmath.loans.domain.models.ApplicationDetailsInterface
import com.apmath.loans.domain.data.Status
import com.apmath.loans.domain.data.Money

data class ApplicationDetails (
    override val status: Status,
    override val interest: Int,
    override val term: Int
) : ApplicationDetailsInterface
