package com.pro.anat.oxdictionary.presentation.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import com.pro.anat.oxdictionary.presentation.app.di.app.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


@SuppressLint("Registered")
class OxDictionaryApp : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? = activityInjector
}