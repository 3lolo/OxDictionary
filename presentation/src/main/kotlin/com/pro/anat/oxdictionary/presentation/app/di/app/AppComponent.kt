package com.pro.anat.oxdictionary.presentation.app.di.app

import android.app.Application
import com.pro.anat.oxdictionary.presentation.app.OxDictionaryApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityBuilderModule::class,
    NetModule::class,
    StorageModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: OxDictionaryApp)
}