package com.pro.anat.oxdictionary.presentation.module_dictionary.search.delegates

import android.view.ViewGroup
import com.pro.anat.oxdictionary.BR
import com.pro.anat.oxdictionary.R
import com.pro.anat.oxdictionary.presentation.base.recycler.AdapterDelegate
import com.pro.anat.oxdictionary.presentation.base.recycler.BindingHolder
import com.pro.anat.oxdictionary.presentation.base.recycler.OnRecyclerItemClick
import com.pro.anat.oxdictionary.presentation.models.Field
import com.pro.anat.oxdictionary.presentation.models.FieldType
import com.pro.anat.oxdictionary.presentation.models.Transcription

class SearchTranscriptionDelegate : AdapterDelegate<Field>() {

    override fun getLayoutId(): Int = R.layout.item_transition_search

    override fun isForViewType(item: Field, position: Int): Boolean = FieldType.TRANSCRIPTION == item.getType()

    override fun onCreateViewHolder(parent: ViewGroup, listener: OnRecyclerItemClick<Field>?): BindingHolder<*> {
        val binding = inflateViewDataBinding(parent)
        binding.setVariable(BR.actionHandler, listener)
        return BindingHolder.newInstance(binding)
    }

    override fun onBindViewHolder(item: Field, holder: BindingHolder<*>, position: Int) {
        item is Transcription
        holder.binding.setVariable(BR.position, position)
        holder.binding.setVariable(BR.model, item)
    }
}