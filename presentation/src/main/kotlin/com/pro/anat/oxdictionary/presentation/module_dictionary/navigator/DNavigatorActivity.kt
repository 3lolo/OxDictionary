package com.pro.anat.oxdictionary.presentation.module_dictionary.navigator

import androidx.navigation.Navigation
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.ActivityMainBinding
import com.pro.anat.oxdictionary.presentation.base.BaseActivity
import com.pro.anat.oxdictionary.presentation.base.SingleLiveEvent


class DNavigatorActivity : BaseActivity<ActivityMainBinding, NavigatorVM>() {

    var networkStatus: SingleLiveEvent<Boolean> = SingleLiveEvent()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun performDataBinding(databinding: ActivityMainBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
    }

    override fun onSupportNavigateUp(): Boolean = Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()
}
