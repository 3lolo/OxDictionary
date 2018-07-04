package com.pro.anat.oxdictionary.presentation.app.di.search

import com.pro.anat.oxdictionary.presentation.module_dictionary.search.SearchView
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [InfoModule::class])
interface SearchComponent : AndroidInjector<SearchView> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<SearchView>()
}
