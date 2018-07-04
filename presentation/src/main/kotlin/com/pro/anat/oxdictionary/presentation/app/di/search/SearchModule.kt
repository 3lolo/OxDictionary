package com.pro.anat.oxdictionary.presentation.app.di.search

import android.arch.lifecycle.ViewModelProviders
import com.pro.anat.oxdictionary.presentation.module_dictionary.search.SearchVM
import com.pro.anat.oxdictionary.presentation.module_dictionary.search.SearchView
import dagger.Module
import dagger.Provides

@Module
class SearchModule {
    @Provides
    fun getVM(view: SearchView): SearchVM {
        return ViewModelProviders.of(view)[SearchVM::class.java]
    }
}
