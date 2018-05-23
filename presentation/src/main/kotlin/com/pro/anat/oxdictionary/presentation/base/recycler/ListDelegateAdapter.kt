package com.pro.anat.oxdictionary.presentation.base.recycler


import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.ViewGroup
import java.util.*

class ListDelegateAdapter<T>(private val mListener: OnRecyclerItemClick<T>?,
                             private val delegatesManager: AdapterDelegatesManager<T>,
                             private val items: MutableList<T>)
    : RecyclerView.Adapter<BindingHolder<*>>() {


    private constructor(builder: Builder<T>) : this(builder.mListener, builder.delegatesManager, builder.items as MutableList<T>)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<*> = delegatesManager.onCreateViewHolder(parent, viewType, mListener)
    override fun onBindViewHolder(holder: BindingHolder<*>, position: Int) = delegatesManager.onBindViewHolder(items[position], position, holder, null)
    override fun getItemViewType(position: Int): Int = delegatesManager.getItemViewType(items[position], position)
    override fun onViewRecycled(holder: BindingHolder<*>) = delegatesManager.onViewRecycled(holder)
    override fun onFailedToRecycleView(holder: BindingHolder<*>): Boolean = delegatesManager.onFailedToRecycleView(holder)
    override fun onViewAttachedToWindow(holder: BindingHolder<*>) = delegatesManager.onViewAttachedToWindow(holder)
    override fun onViewDetachedFromWindow(holder: BindingHolder<*>) = delegatesManager.onViewDetachedFromWindow(holder)

    /**
     * Get the items / data source of this adapter
     *
     * @return The items / data source
     */
    fun getItems(): List<T> = items

    fun getItem(position: Int): T? = if (position in 0..(itemCount - 1)) items[position] else null

    override fun getItemCount(): Int = items.size

    fun updateItems(models: MutableList<T>?) {
        items.addAll(0, models ?: ArrayList())
        notifyDataSetChanged()
    }

    @JvmOverloads
    fun updateItemByPosition(model: T?, position: Int, notifyChanged: Boolean = true) {
        if (position in 0..items.size && model != null) {
            items[position] = model
            if (notifyChanged) {
                notifyItemChanged(position)
            }
        }
    }

    fun updateItemsByPosition(array: SparseArray<T>) {
        for (i in 0 until array.size()) {
            val position = array.keyAt(i)
            updateItemByPosition(array.get(position), position)
        }
    }

    fun removeItem(position: Int) {
        if (position in 0 until items.size) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeItem(from: Int, count: Int) {
        if (from in 0..items.size - count) {
            for (i in 0 until count)
                items.removeAt(from)
            notifyItemRangeRemoved(from, count)
        }
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        items.add(item)
        notifyItemRangeChanged(items.size - 1, 1)
    }

    fun addItem(position: Int, item: T) {
        if (position in 0 until items.size) {
            items.add(position, item)
            notifyItemInserted(position)
        }
    }

    fun addItem(from: Int, models: MutableList<T>?) {
        if (from in 0 until items.size && models != null) {
            items.addAll(from, models)
            notifyItemRangeInserted(from, models.size)
        }
    }


    fun insertItems(data: MutableList<T>, position: Int) {
        if (position >= 0 && items.size >= position && !data.isEmpty()) {
            items.addAll(position, data)
            notifyItemRangeInserted(position, data.size)
        }
    }

    fun deleteItems(position: Int, count: Int) {
        var lCount = count
        if (position >= 0 && position < items.size && position + lCount <= items.size) {
            while (lCount > 0) {
                items.removeAt(position)
                lCount--
            }
            notifyItemRangeRemoved(position, count)
        }
    }

    class Builder<T> {
        internal var mListener: OnRecyclerItemClick<T>? = null
        internal var delegatesManager: AdapterDelegatesManager<T>
        internal var items: List<T>

        init {
            delegatesManager = AdapterDelegatesManager()
            items = ArrayList()
        }

        fun setListener(listener:  OnRecyclerItemClick<T>): Builder<T> {
            this.mListener = listener
            return this
        }

        fun setDelegatesManager(delegatesManager: AdapterDelegatesManager<T>?): Builder<T> {
            this.delegatesManager = delegatesManager ?: AdapterDelegatesManager()
            return this
        }

        fun setItems(items: List<T>?): Builder<T> {
            this.items = items ?: mutableListOf()
            return this
        }

        fun addDelegate(item: AdapterDelegate<T>): Builder<T> {
            delegatesManager.addDelegate(item)
            return this
        }

        fun build(): ListDelegateAdapter<T> = ListDelegateAdapter(this)
    }

}