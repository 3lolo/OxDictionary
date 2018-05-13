package com.pro.anat.oxdictionary.presentation.app.di.navigator

import com.pro.anat.oxdictionary.presentation.module_dictionary.navigator.DNavigatorActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [DNavigatorModule::class])
interface DNavigatorComponent : AndroidInjector<DNavigatorActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<DNavigatorActivity>()
}