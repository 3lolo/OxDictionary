package com.pro.anat.oxdictionary.presentation.module_dictionary.info

import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentInfoBinding
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView

class TranscriptionView : BaseFragmentView<FragmentInfoBinding, TranscriptionVM>() {
    override fun getLayoutId(): Int = R.layout.fragment_info

    override fun performDataBinding(databinding: FragmentInfoBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }


}