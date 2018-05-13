package com.pro.anat.oxdictionary.presentation.module_dictionary.navigator

import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.ActivityMainBinding
import com.pro.anat.oxdictionary.presentation.base.BaseActivity

class DNavigatorActivity : BaseActivity<ActivityMainBinding, DNavigatorViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun performDataBinding(databinding: ActivityMainBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }
}
