package com.example.icerock_t1.auth.data.loginDto

import com.google.gson.annotations.SerializedName

data class PermissionsDto(
    @SerializedName("checks") val checks: String,
    @SerializedName("metadata") val metadata: String,
    @SerializedName("contents") val contents: String
)
