package com.pro.anat.oxdictionary.presentation.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


abstract class BaseFragmentView<B : ViewDataBinding, VM : BaseViewModel<*>>
    : android.support.v4.app.Fragment(), BaseView {

    @Inject
    lateinit var mViewModel: VM
    private lateinit var mViewDataBinding: B
    private var mRootView: View? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mViewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding.root
        performDataBinding(mViewDataBinding)
        return mRootView
    }

    abstract fun performDataBinding(databinding: B)

    fun attachFragmentViews(view: View?) {

    }

    fun initFragmentViews(savedInstanceState: Bundle?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mViewModel)
    }

}