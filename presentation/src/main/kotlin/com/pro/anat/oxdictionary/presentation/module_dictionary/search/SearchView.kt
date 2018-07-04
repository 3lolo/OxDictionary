package com.pro.anat.oxdictionary.presentation.module_dictionary.search

import android.arch.lifecycle.Observer
import android.util.Log
import androidx.navigation.Navigation
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentSearchBinding
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView

class SearchView : BaseFragmentView<FragmentSearchBinding, SearchVM>() {
    override fun getLayoutId() = R.layout.fragment_search

    override fun performDataBinding(databinding: FragmentSearchBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
        mViewModel.navToTranscription.observe(this, Observer { t ->
            run {
                Log.e("lolo", t?.name)
                activity?.let {Navigation.findNavController(it, R.id.nav_host_fragment).navigate(R.id.action_searchView_to_infoView) }
                t?.name
            }
        })
    }

}
