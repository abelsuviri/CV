package com.abelsuviri.abelsuviricv.data.network

import com.abelsuviri.abelsuviricv.data.model.CvModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * @author Abel Suviri
 */

interface CvService {
    @GET("abelsuviri/a245acdff666c21c6e4196473b01aa70/raw/d5d73fce2aceaae94a42ee95623c222687df10ef/abelsuviricv.json")
    fun getCv(): Deferred<CvModel>
}