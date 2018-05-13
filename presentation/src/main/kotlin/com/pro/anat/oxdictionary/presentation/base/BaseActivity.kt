package com.pro.anat.oxdictionary.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<*>>
    : AppCompatActivity(), BaseView {
    @Inject
    protected lateinit var mViewModel: VM
    private lateinit var mViewDataBinding: B

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mViewModel)
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        performDataBinding(mViewDataBinding)
        attachViews()
        initViews(savedInstanceState)
    }

    abstract fun performDataBinding(databinding: B)

    protected fun attachViews() {

    }

    protected fun initViews(savedInstanceState: Bundle?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mViewModel)
    }

}