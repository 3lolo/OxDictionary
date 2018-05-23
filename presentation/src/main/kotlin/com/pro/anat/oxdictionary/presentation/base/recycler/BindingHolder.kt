package com.pro.anat.oxdictionary.presentation.base.recycler

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView


class BindingHolder<VB : ViewDataBinding> private constructor(val binding: VB) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun <VB : ViewDataBinding> newInstance(viewDataBinding: VB): BindingHolder<VB> = BindingHolder(viewDataBinding)
    }

//    fun getBinding(): VB {
//        return binding
//    }
}