package com.pro.anat.oxdictionary.presentation.app.di.home

import com.pro.anat.oxdictionary.presentation.app.di.navigator.HomeModule
import com.pro.anat.oxdictionary.presentation.module_dictionary.home.HomeView
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [HomeModule::class])
interface HomeComponent : AndroidInjector<HomeView> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeView>()
}
