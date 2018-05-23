package com.pro.anat.oxdictionary.presentation.module_dictionary.search

import com.pro.anat.oxdictionary.presentation.base.BaseViewModel
import com.pro.anat.oxdictionary.presentation.base.recycler.ListConfig
import com.pro.anat.oxdictionary.presentation.base.recycler.ListDelegateAdapter
import com.pro.anat.oxdictionary.presentation.base.recycler.OnRecyclerItemClick
import com.pro.anat.oxdictionary.presentation.models.Field
import com.pro.anat.oxdictionary.presentation.models.Transcription
import com.pro.anat.oxdictionary.presentation.module_dictionary.search.delegates.SearchTranscriptionDelegate
import javax.inject.Inject


class SearchVM @Inject constructor() : BaseViewModel<SearchView>() {


    private var mItemClick: OnRecyclerItemClick<Field> = object : OnRecyclerItemClick<Field> {
        override fun onItemClick(model: Field, position: Int) {
            actionClick(model, position)
        }
    }
    private val adapter: ListDelegateAdapter<Field> = ListDelegateAdapter.Builder<Field>()
            .setListener(mItemClick)
            .addDelegate(SearchTranscriptionDelegate())
            .setItems(listOf(Transcription("lolo", "[lolo]"),
                    Transcription("lolo", "[lolo]"),
                    Transcription("lolo", "[lolo]"),
                    Transcription("lolo", "[lolo]")))
            .build()
    private var listBuilder: ListConfig.Builder

    init {
        listBuilder = ListConfig.Builder(adapter).setLayoutManagerProvider(ListConfig.SimpleLinearLayoutManagerProvider())
    }

    private fun actionClick(model: Field, position: Int) {

    }

    fun actionSearch(query: String) {

    }

    fun getListBuilder(): ListConfig.Builder = listBuilder
}