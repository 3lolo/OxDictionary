package com.pro.anat.oxdictionary.presentation.base.recycler

interface OnRecyclerItemClick<T> {
    fun onItemClick(model: T, position: Int)
}