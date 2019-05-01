package com.abelsuviri.abelsuviricv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abelsuviri.abelsuviricv.data.model.CvModel
import com.abelsuviri.abelsuviricv.data.network.CvService
import com.abelsuviri.abelsuviricv.data.network.Result
import com.abelsuviri.abelsuviricv.data.repository.CvRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Abel Suviri
 */

class MainViewModel @Inject constructor(private val cvRepository: CvRepository) : ViewModel() {

    var cv: MutableLiveData<CvModel> = MutableLiveData()

    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var hasFailed: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * This method calls the service to get the CV data. If the result is success then the CV will be displayed in the UI.
     */
    fun getCv() {
        isLoading.value = true

        GlobalScope.launch {
            val result = cvRepository.getCv()
            if (result is Result.Success) {
                cv.postValue(result.data)
                setSuccess()
            } else {
                setFailed()
            }
        }
    }

    /**
     * When a server call has been successful we hide the progress dialog and reset failures.
     * This functionality is handled in the UI
     */
    private fun setSuccess() {
        isLoading.postValue(false)
        hasFailed.postValue(false)
    }

    /**
     * When a server call has failed we hide the progress dialog and display an error message.
     * This functionality is handled in the UI
     */
    private fun setFailed() {
        isLoading.postValue(false)
        hasFailed.postValue(true)
    }
}