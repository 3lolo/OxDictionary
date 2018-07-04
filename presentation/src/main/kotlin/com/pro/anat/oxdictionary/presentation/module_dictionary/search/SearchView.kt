package com.pro.anat.oxdictionary.presentation.module_dictionary.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.util.Log
import androidx.navigation.Navigation
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.databinding.FragmentSearchBinding
import com.pro.anat.oxdictionary.presentation.app.di.app.AppViewModelFactory
import com.pro.anat.oxdictionary.presentation.base.BaseFragmentView
import javax.inject.Inject

class SearchView : BaseFragmentView<FragmentSearchBinding, SearchVM>() {
    @Inject
    lateinit var factory: AppViewModelFactory

    override fun provideViewModel() {
        mViewModel = ViewModelProviders.of(this, factory).get(SearchVM::class.java)
    }

    override fun getLayoutId() = R.layout.fragment_search

    override fun performDataBinding(databinding: FragmentSearchBinding) {
        databinding.setVariable(BR.vm, mViewModel)
        databinding.executePendingBindings()
        mViewModel.navToTranscription.observe(this, Observer { t ->
            run {
                Log.e("lolo", t?.name)
                activity?.let { Navigation.findNavController(it, R.id.nav_host_fragment).navigate(R.id.action_searchView_to_infoView) }
                t?.name
            }
        })
    }

}
