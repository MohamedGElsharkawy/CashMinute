package com.sharkawy.cashminute.entities

import com.google.gson.annotations.SerializedName


data class CreditResponse(
    @SerializedName("status")
    var status: String?,
    @SerializedName("msg")
    var msg: String?,
)