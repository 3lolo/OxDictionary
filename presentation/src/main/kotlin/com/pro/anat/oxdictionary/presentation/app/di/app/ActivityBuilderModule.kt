package com.pro.anat.oxdictionary.presentation.app.di.app

import android.app.Activity
import com.pro.anat.oxdictionary.presentation.app.di.navigator.DNavigatorComponent
import com.pro.anat.oxdictionary.presentation.module_dictionary.navigator.DNavigatorActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Singleton
@Module
abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(DNavigatorActivity::class)
    internal abstract fun bindDNavigatorActivity(builder: DNavigatorComponent.Builder):
            AndroidInjector.Factory<out Activity>

}