package com.pro.anat.oxdictionary.presentation.module_dictionary.home

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentHomeBinding
import com.pro.anat.oxdictionary.presentation.app.di.app.AppViewModelFactory
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView
import javax.inject.Inject

class HomeView : BaseFragmentView<FragmentHomeBinding, HomeVM>() {
    @Inject
    lateinit var factory: AppViewModelFactory

    override fun provideViewModel() {
        mViewModel = ViewModelProviders.of(this, factory).get(HomeVM::class.java)
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun performDataBinding(databinding: FragmentHomeBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }

    override fun attachFragmentViews(view: View?) {
//        var home  = ViewModelProviders.of(this).get(HomeVM::class.java)
//        home = home;
    }
}