package com.pro.anat.oxdictionary.presentation.app.di.navigator

import com.pro.anat.oxdictionary.presentation.app.di.home.HomeComponent
import com.pro.anat.oxdictionary.presentation.app.di.search.SearchComponent
import dagger.Module

@Module(subcomponents = [HomeComponent::class,
    SearchComponent::class])
class DNavigatorModule