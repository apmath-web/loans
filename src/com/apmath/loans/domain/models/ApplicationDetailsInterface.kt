package com.apmath.loans.domain.models

import com.apmath.loans.domain.data.Status
import com.apmath.loans.domain.data.Money

interface ApplicationDetailsInterface {
    val status: Status
    val interest: Float
    val term: Int
}
