package com.abelsuviri.abelsuviricv

import android.app.Activity
import android.app.Application
import com.abelsuviri.abelsuviricv.di.components.AppComponent
import com.abelsuviri.abelsuviricv.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author Abel Suviri
 */

class CvApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    val component: AppComponent = DaggerAppComponent.builder().build()

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingInjector
    }
}