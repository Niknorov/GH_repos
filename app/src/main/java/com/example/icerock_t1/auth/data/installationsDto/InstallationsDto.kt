package com.example.icerock_t1.auth.data.installationsDto

import com.google.gson.annotations.SerializedName

data class InstallationsDto(

    @SerializedName("total_count") val totalCount : Int,
    @SerializedName("installations") val installations : List<InstallationDto>
)
