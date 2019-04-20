package com.apmath.loans.domain.models.data

import com.google.gson.annotations.SerializedName

enum class Type {
    @SerializedName("regular")
    REGULAR,
    @SerializedName("early")
    EARLY,
    @SerializedName("next")
    NEXT
}
