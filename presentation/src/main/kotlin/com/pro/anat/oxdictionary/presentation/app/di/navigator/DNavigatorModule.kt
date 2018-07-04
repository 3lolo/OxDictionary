package com.pro.anat.oxdictionary.presentation.app.di.navigator

import android.arch.lifecycle.ViewModelProviders
import com.pro.anat.oxdictionary.presentation.app.di.home.HomeComponent
import com.pro.anat.oxdictionary.presentation.app.di.search.InfoComponent
import com.pro.anat.oxdictionary.presentation.app.di.search.SearchComponent
import com.pro.anat.oxdictionary.presentation.module_dictionary.navigator.DNavigatorActivity
import com.pro.anat.oxdictionary.presentation.module_dictionary.navigator.DNavigatorViewModel
import dagger.Module
import dagger.Provides

@Module(subcomponents = [HomeComponent::class,
    SearchComponent::class,
    InfoComponent::class])
class DNavigatorModule {

    @Provides
    fun provideViewModel(view: DNavigatorActivity): DNavigatorViewModel {
        return ViewModelProviders.of(view)[DNavigatorViewModel::class.java]
    }

}