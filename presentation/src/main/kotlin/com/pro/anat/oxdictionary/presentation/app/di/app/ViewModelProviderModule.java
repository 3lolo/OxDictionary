package com.pro.anat.oxdictionary.presentation.app.di.app;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.pro.anat.oxdictionary.presentation.app.di.ViewModelKey;
import com.pro.anat.oxdictionary.presentation.module_dictionary.home.HomeVM;
import com.pro.anat.oxdictionary.presentation.module_dictionary.info.InfoVM;
import com.pro.anat.oxdictionary.presentation.module_dictionary.navigator.NavigatorVM;
import com.pro.anat.oxdictionary.presentation.module_dictionary.search.SearchVM;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelProviderModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeVM.class)
    abstract ViewModel bindHomeViewModel(HomeVM vm);

    @Binds
    @IntoMap
    @ViewModelKey(NavigatorVM.class)
    abstract ViewModel bindNavigatorViewModel(NavigatorVM vm);

    @Binds
    @IntoMap
    @ViewModelKey(SearchVM.class)
    abstract ViewModel bindSearchViewModel(SearchVM vm);

    @Binds
    @IntoMap
    @ViewModelKey(InfoVM.class)
    abstract ViewModel bindInfoViewModel(InfoVM vm);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
