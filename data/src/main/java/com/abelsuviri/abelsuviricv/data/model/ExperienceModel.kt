package com.abelsuviri.abelsuviricv.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Abel Suviri
 */

data class ExperienceModel(
    @SerializedName("Company") val companyName: String,
    @SerializedName("Position") val jobPosition: String,
    @SerializedName("FromDate") val fromDate: String,
    @SerializedName("ToDate") val toDate: String,
    @SerializedName("Description") val description: String
)