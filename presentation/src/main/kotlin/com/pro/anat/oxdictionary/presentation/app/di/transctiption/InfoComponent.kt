package com.pro.anat.oxdictionary.presentation.app.di.search

import com.pro.anat.oxdictionary.presentation.module_dictionary.info.InfoView
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [InfoModule::class])
interface InfoComponent : AndroidInjector<InfoView> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<InfoView>()
}
