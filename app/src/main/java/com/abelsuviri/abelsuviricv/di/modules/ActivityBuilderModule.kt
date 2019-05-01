package com.abelsuviri.abelsuviricv.di.modules

import com.abelsuviri.abelsuviricv.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Abel Suviri
 */

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}