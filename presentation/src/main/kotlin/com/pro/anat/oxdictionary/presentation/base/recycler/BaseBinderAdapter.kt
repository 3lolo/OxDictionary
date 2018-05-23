package com.pro.anat.oxdictionary.presentation.base.recycler

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView





class BaseBinderAdapter{

    /**
     * Binding adapter to apply RecyclerView config.
     * Sample:
     * <pre>
     * `&lt;android.support.v7.widget.RecyclerView
     * android:layout_width="match_parent"
     * android:layout_height="match_parent"
     * app:listConfig="@{viewModel.listConfig}"
     * /&gt;
    ` *
    </pre> *
     *
     * @param recyclerView  The RecyclerView to apply config
     * @param configBuilder The config for RecyclerView
     */
    @BindingAdapter("listConfig")
    fun configRecyclerView(recyclerView: RecyclerView, configBuilder: ListConfig.Builder?) {
        if (configBuilder == null) return
        val config = configBuilder!!.build(recyclerView.context)
        config.applyConfig(recyclerView.context, recyclerView)
    }
}