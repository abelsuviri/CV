package com.abelsuviri.abelsuviricv.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.abelsuviri.abelsuviricv.data.model.CvModel
import com.abelsuviri.abelsuviricv.data.network.Result
import com.abelsuviri.abelsuviricv.data.repository.CvRepository
import com.abelsuviri.abelsuviricv.viewmodel.mock.MockResponse
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * @author Abel Suviri
 */

class MainViewModelTest {
    @Mock
    lateinit var cvRepository: CvRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var lifecycleOwner: LifecycleOwner

    lateinit var lifecycleRegistry: LifecycleRegistry

    private lateinit var gson: Gson

    @InjectMocks
    lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        gson = Gson()
    }

    @Test
    fun test_get_cv_successfully() {
        val cvResponseModel = Result.Success(gson.fromJson(MockResponse.mockResponse, CvModel::class.java))

        Mockito.`when`(runBlocking { cvRepository.getCv() }).thenReturn(cvResponseModel)

        mainViewModel.getCv()

        mainViewModel.cv.observe(lifecycleOwner, Observer {
            Assert.assertEquals(it, cvResponseModel.data)
            Assert.assertEquals(mainViewModel.isLoading.value, false)
            Assert.assertEquals(mainViewModel.hasFailed.value, false)
        })
    }

    @Test
    fun test_get_cv_unsuccessfully() {
        val throwable = Result.Error(Throwable())
        Mockito.`when`(runBlocking { cvRepository.getCv() }).thenReturn(throwable)

        mainViewModel.getCv()

        mainViewModel.cv.observe(lifecycleOwner, Observer {
            Assert.assertEquals(it, throwable)
            Assert.assertEquals(mainViewModel.isLoading.value, false)
            Assert.assertEquals(mainViewModel.hasFailed.value, true)
        })
    }
}