package com.pro.anat.oxdictionary.presentation.app.di.app

import android.app.Application
import android.content.Context
import com.pro.anat.oxdictionary.presentation.app.di.navigator.DNavigatorComponent
import com.pro.anat.oxdictionary.presentation.module_dictionary.navigator.DNavigatorViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [DNavigatorComponent::class])
class AppModule {
    @Provides
    @Singleton
    fun getContext(appContext: Application): Context = appContext

    @Provides
    @Singleton
    fun getDanvi(): DNavigatorViewModel = DNavigatorViewModel()


}