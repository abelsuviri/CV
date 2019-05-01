package com.abelsuviri.abelsuviricv.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Abel Suviri
 */

data class CvModel(
    @SerializedName("Summary") val summary: String,
    @SerializedName("TechnicalKnowledge") val knowledge: List<String>,
    @SerializedName("Experience") val experience: List<ExperienceModel>
)