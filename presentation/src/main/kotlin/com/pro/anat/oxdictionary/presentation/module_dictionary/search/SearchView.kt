package com.pro.anat.oxdictionary.presentation.module_dictionary.search

import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentSearchBinding
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView

class SearchView : BaseFragmentView<FragmentSearchBinding, SearchVM>() {

    override fun getLayoutId() = R.layout.fragment_search

    override fun performDataBinding(databinding: FragmentSearchBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }
}