package com.pro.anat.oxdictionary.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<*>>
    : AppCompatActivity(), BaseView, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    protected lateinit var mViewModel: VM
    private lateinit var mViewDataBinding: B

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

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
       // lifecycle.removeObserver(mViewModel)
    }

}