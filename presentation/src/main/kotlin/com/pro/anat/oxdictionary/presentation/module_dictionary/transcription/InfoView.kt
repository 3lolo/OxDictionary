package com.pro.anat.oxdictionary.presentation.module_dictionary.info

import android.arch.lifecycle.ViewModelProviders
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentInfoBinding
import com.pro.anat.oxdictionary.presentation.app.di.app.AppViewModelFactory
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView
import javax.inject.Inject

class InfoView : BaseFragmentView<FragmentInfoBinding, InfoVM>() {
    @Inject
    lateinit var factory: AppViewModelFactory

    override fun provideViewModel() {
        mViewModel = ViewModelProviders.of(this, factory).get(InfoVM::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_info

    override fun performDataBinding(databinding: FragmentInfoBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }
}