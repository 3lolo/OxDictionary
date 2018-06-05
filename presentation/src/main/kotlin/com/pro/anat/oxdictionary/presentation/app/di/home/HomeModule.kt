package com.pro.anat.oxdictionary.presentation.app.di.navigator

import android.arch.lifecycle.ViewModelProviders
import com.pro.anat.oxdictionary.presentation.module_dictionary.home.HomeVM
import com.pro.anat.oxdictionary.presentation.module_dictionary.home.HomeView
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun getVM(view: HomeView): HomeVM {
        return ViewModelProviders.of(view)[HomeVM::class.java]
    }
}