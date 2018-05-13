package com.pro.anat.oxdictionary.presentation.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseViewModel<V : BaseView> : ViewModel(), LifecycleObserver {
    @Inject
    lateinit var view: V
}