package com.pro.anat.oxdictionary.presentation.app.di.search

import android.arch.lifecycle.ViewModelProviders
import com.pro.anat.oxdictionary.presentation.module_dictionary.info.InfoVM
import com.pro.anat.oxdictionary.presentation.module_dictionary.info.InfoView
import dagger.Module
import dagger.Provides

@Module
class InfoModule {

    @Provides
    fun getVM(view: InfoView): InfoVM {
        return ViewModelProviders.of(view)[InfoVM::class.java]
    }
}