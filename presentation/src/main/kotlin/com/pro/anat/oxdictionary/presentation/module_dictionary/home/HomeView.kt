package com.pro.anat.oxdictionary.presentation.module_dictionary.home

import android.view.View
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentHomeBinding
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView

class HomeView : BaseFragmentView<FragmentHomeBinding, HomeVM>() {

    override fun getLayoutId() = R.layout.fragment_home

    override fun performDataBinding(databinding: FragmentHomeBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }

    override fun attachFragmentViews(view: View?) {
    }
}