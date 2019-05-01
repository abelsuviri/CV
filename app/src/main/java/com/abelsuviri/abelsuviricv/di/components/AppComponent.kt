package com.abelsuviri.abelsuviricv.di.components

import com.abelsuviri.abelsuviricv.CvApplication
import com.abelsuviri.abelsuviricv.di.modules.ActivityBuilderModule
import com.abelsuviri.abelsuviricv.di.modules.ServiceModule
import com.abelsuviri.abelsuviricv.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Abel Suviri
 */

@Singleton
@Component(modules = [ActivityBuilderModule::class, AndroidInjectionModule::class, ServiceModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(cvApplication: CvApplication)
}