package com.example.icerock_t1.auth.data.loginDto

import com.google.gson.annotations.SerializedName

data class InstallationsDto(

    @SerializedName("total_count") val total_count : Int,
    @SerializedName("installations") val installations : List<InstallationDto>
)
