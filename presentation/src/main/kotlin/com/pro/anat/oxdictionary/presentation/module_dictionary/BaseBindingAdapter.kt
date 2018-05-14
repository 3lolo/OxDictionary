package com.pro.anat.oxdictionary.presentation.module_dictionary

import android.databinding.BindingAdapter
import android.view.View
import androidx.navigation.findNavController


object BaseBindingAdapter {
    @BindingAdapter("bind:navigateTo")
    @JvmStatic
    fun bindNavigation(view: View, navId: Int) = view.setOnClickListener({ view.findNavController().navigate(navId) })
}
