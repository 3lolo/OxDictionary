package com.pro.anat.oxdictionary.presentation.app.di.navigator

import android.support.v4.app.Fragment
import com.pro.anat.oxdictionary.presentation.app.di.home.HomeComponent
import com.pro.anat.oxdictionary.presentation.app.di.search.SearchComponent
import com.pro.anat.oxdictionary.presentation.module_dictionary.home.HomeView
import com.pro.anat.oxdictionary.presentation.module_dictionary.search.SearchView
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Singleton
@Module
abstract class DNavigatorFragmentProvider {

    @Binds
    @IntoMap
    @FragmentKey(HomeView::class)
    internal abstract fun bindHomeView(builder: HomeComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(SearchView::class)
    internal abstract fun bindSearchView(builder: SearchComponent.Builder): AndroidInjector.Factory<out Fragment>

}

