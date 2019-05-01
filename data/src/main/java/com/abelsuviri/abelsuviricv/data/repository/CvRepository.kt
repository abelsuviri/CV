package com.abelsuviri.abelsuviricv.data.repository

import com.abelsuviri.abelsuviricv.data.model.CvModel
import com.abelsuviri.abelsuviricv.data.network.CvService
import com.abelsuviri.abelsuviricv.data.network.Result
import java.lang.Exception
import javax.inject.Inject

/**
 * @author Abel Suviri
 */

class CvRepository @Inject constructor(private val cvService: CvService) {
    suspend fun getCv(): Result<CvModel> {
        return try {
            val response = cvService.getCv()
            val result = response.await()

            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}