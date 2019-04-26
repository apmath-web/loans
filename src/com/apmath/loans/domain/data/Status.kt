package com.apmath.loans.domain.data

import com.google.gson.annotations.SerializedName

enum class Status {
    @SerializedName("approved")
    APPROVED,
    @SerializedName("rejected")
    REJECTED,
    @SerializedName("pending")
    PENDING
}
