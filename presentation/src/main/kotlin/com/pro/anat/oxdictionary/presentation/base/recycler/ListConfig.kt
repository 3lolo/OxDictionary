package com.pro.anat.oxdictionary.presentation.base.recycler

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import java.util.*


class ListConfig private constructor(private val mAdapter: RecyclerView.Adapter<*>?,
                                     private val mLayoutManagerProvider: LayoutManagerProvider?,
                                     private val mItemAnimator: RecyclerView.ItemAnimator?,
                                     itemDecorations: List<RecyclerView.ItemDecoration>?,
                                     scrollListeners: List<RecyclerView.OnScrollListener>?,
                                     private val mItemTouchHelper: ItemTouchHelper?,
                                     private val mHasFixedSize: Boolean,
                                     private val hasDivider: Boolean) {
    private val mItemDecorations: List<RecyclerView.ItemDecoration>
    private val mScrollListeners: List<RecyclerView.OnScrollListener>

    init {
        mItemDecorations = itemDecorations ?: Collections.emptyList()
        mScrollListeners = scrollListeners ?: Collections.emptyList()
    }

    /**
     * Applies defined configuration for RecyclerView
     *
     * @param context      the context
     * @param recyclerView the target recycler view for applying the configuration
     */
    fun applyConfig(context: Context, recyclerView: RecyclerView) {
        if (mAdapter == null || mLayoutManagerProvider == null)
            return

        recyclerView.layoutManager = mLayoutManagerProvider[context]
        recyclerView.setHasFixedSize(mHasFixedSize)
        recyclerView.adapter = mAdapter
        for (itemDecoration in mItemDecorations) {
            recyclerView.addItemDecoration(itemDecoration)
        }
        for (scrollListener in mScrollListeners) {
            recyclerView.addOnScrollListener(scrollListener)
        }

        //   //     if (hasDivider) {
        //            recyclerView.addItemDecoration(new DividerItemDecoration(context, R.drawable.divider));
        //     //   }
        if (mItemAnimator != null) {
            recyclerView.itemAnimator = mItemAnimator
        }
        mItemTouchHelper?.attachToRecyclerView(recyclerView)
    }

    /**
     * Builder for setting ListConfig
     * Sample:
     * <pre>
     * `ListConfig listConfig = new ListConfig.Builder(mAdapter)
     * .setLayoutManagerProvider(new SimpleGridLayoutManagerProvider(mSpanCount, getSpanSizeLookup()))
     * .addItemDecoration(new ColorDividerItemDecoration(color, spacing, SPACE_LEFT|SPACE_TOP, false))
     * .setDefaultDividerEnabled(true)
     * .addOnScrollListener(new OnLoadMoreScrollListener(mCallback))
     * .setItemAnimator(getItemAnimator())
     * .setHasFixedSize(true)
     * .setItemTouchHelper(getItemTouchHelper())
     * .build(context);
    ` *
    </pre> *
     * If LinearLayoutManager will be used by default
     */
    class Builder
    /**
     * Creates new Builder for config RecyclerView with the adapter
     *
     * @param adapter the adapter, which will be set to the RecyclerView
     */
    (private val mAdapter: RecyclerView.Adapter<*>) {
        private var mLayoutManagerProvider: LayoutManagerProvider? = null
        private var mItemAnimator: RecyclerView.ItemAnimator? = null
        private var mItemDecorations: MutableList<RecyclerView.ItemDecoration>? = null
        private var mOnScrollListeners: MutableList<RecyclerView.OnScrollListener>? = null
        private var mItemTouchHelper: ItemTouchHelper? = null
        private var mHasFixedSize: Boolean = false
        private var mDefaultDividerSize = -1
        private var hasDivider: Boolean = false
        private val mItemDecorationProvider: ItemDecorationProvider? = null

        /**
         * Set Layout manager provider. If not set default [LinearLayoutManager] will be applied
         *
         * @param layoutManagerProvider the layout manager provider. Can be custom or one of
         * simple: [SimpleLinearLayoutManagerProvider],
         * [SimpleGridLayoutManagerProvider] or
         * [SimpleStaggeredGridLayoutManagerProvider].
         * @return the builder
         */
        fun setLayoutManagerProvider(layoutManagerProvider: LayoutManagerProvider): Builder {
            mLayoutManagerProvider = layoutManagerProvider
            return this
        }

        /**
         * Set [RecyclerView.ItemAnimator]
         *
         * @param itemAnimator the item animator
         * @return the builder
         */
        fun setItemAnimator(itemAnimator: RecyclerView.ItemAnimator): Builder {
            mItemAnimator = itemAnimator
            return this
        }

        /**
         * Set [RecyclerView.ItemDecoration]
         *
         * @param itemDecoration the item decoration. Can be set any custom item decoration
         * @return the builder
         */
        fun addItemDecoration(itemDecoration: RecyclerView.ItemDecoration): Builder {
            if (mItemDecorations == null) {
                mItemDecorations = ArrayList()
            }
            mItemDecorations!!.add(itemDecoration)
            return this
        }

        /**
         * Set [RecyclerView.OnScrollListener]
         *
         * @param onScrollListener the scroll listener. Can be set any custom or used one of
         * @return the builder
         */
        fun addOnScrollListener(onScrollListener: RecyclerView.OnScrollListener): Builder {
            if (mOnScrollListeners == null) {
                mOnScrollListeners = ArrayList()
            }
            mOnScrollListeners!!.add(onScrollListener)
            return this
        }

        /**
         * Set true if adapter changes cannot affect the size of the RecyclerView.
         * Applied to [RecyclerView.setHasFixedSize]
         *
         * @param isFixedSize true if RecyclerView items have fixed size
         * @return the builder
         */
        fun setHasFixedSize(isFixedSize: Boolean): Builder {
            mHasFixedSize = isFixedSize
            return this
        }

        //        /**
        //         * Set true to apply default divider with default size of 4dp.
        //         *
        //         * @param isEnabled set true to apply default divider.
        //         * @return the builder
        //         */
        //        public Builder setDefaultDividerEnabled(boolean isEnabled) {
        //            mDefaultDividerSize = isEnabled ? 0 : -1;
        //            return this;
        //        }

        /**
         * Set true to apply default divider with default size of 4dp.
         *
         * @param isEnabled set true to apply default divider.
         * @return the builder
         */
        fun setDefaultDividerEnabled(isEnabled: Boolean): Builder {
            hasDivider = isEnabled
            return this
        }

        /**
         * Enables defoult divider with custom size
         *
         * @param size
         * @return the builder
         */
        fun setDefaultDividerSize(size: Int): Builder {
            mDefaultDividerSize = size
            return this
        }

        /**
         * Set [ItemTouchHelper]
         *
         * @param itemTouchHelper the ItemTouchHelper to apply for RecyclerView
         * @return the builder
         */
        fun setItemTouchHelper(itemTouchHelper: ItemTouchHelper): Builder {
            mItemTouchHelper = itemTouchHelper
            return this
        }


        /**
         * Creates new [ListConfig] with defined configuration
         * If LayoutManagerProvider is not set, the [SimpleLinearLayoutManagerProvider]
         * will be used.
         *
         * @param context the context
         * @return the new ListConfig
         */
        fun build(context: Context): ListConfig {
            if (mLayoutManagerProvider == null)
                mLayoutManagerProvider = SimpleLinearLayoutManagerProvider()

            if (mItemDecorations == null) {
                mItemDecorations = ArrayList()
            }
            if (mItemDecorationProvider != null) {
                mItemDecorations!!.add(mItemDecorationProvider[context])
            }

            return ListConfig(
                    mAdapter,
                    mLayoutManagerProvider,
                    mItemAnimator,
                    mItemDecorations,
                    mOnScrollListeners,
                    mItemTouchHelper,
                    mHasFixedSize,
                    hasDivider)
        }
    }

    /**
     * The provider of LayoutManager for RecyclerView
     */
    interface LayoutManagerProvider {
        operator fun get(context: Context): RecyclerView.LayoutManager
    }

    /**
     * The provider of LayoutManager for RecyclerView
     */
    interface ItemDecorationProvider {
        operator fun get(context: Context): RecyclerView.ItemDecoration
    }


    /**
     * The simple LayoutManager provider for [LinearLayoutManager]
     */
    class SimpleLinearLayoutManagerProvider : LayoutManagerProvider {
        override fun get(context: Context): RecyclerView.LayoutManager = LinearLayoutManager(context)
    }

    /**
     * The simple LayoutManager provider for [GridLayoutManager]
     */
//    class SimpleGridLayoutManagerProvider : LayoutManagerProvider {
//        private val mSpanCount: Int
//        private val mSpanSizeLookup: GridLayoutManager.SpanSizeLookup?
//
//        constructor(spanCount: Int = 1) {
//            this.mSpanSizeLookup = StaggeredGridLayoutManager.VERTICAL
//            this.mSpanCount = spanCount
//        }
//
//        constructor(spanCount: Int, spanSizeLookup: GridLayoutManager.SpanSizeLookup) {
//            mSpanCount = spanCount
//            mSpanSizeLookup = spanSizeLookup
//        }
//
//        override fun get(context: Context): RecyclerView.LayoutManager {
//            val layoutManager = GridLayoutManager(context, mSpanCount)
//            if (mSpanSizeLookup != null) layoutManager.spanSizeLookup = mSpanSizeLookup
//            return layoutManager
//        }
//    }

    /**
     * The simple LayoutManager provider for [StaggeredGridLayoutManager]
     */
//    class SimpleStaggeredGridLayoutManagerProvider @JvmOverloads constructor(@param:IntRange(from = 1) private val mSpanCount: Int, private val mOrientation: Int = StaggeredGridLayoutManager.VERTICAL) : LayoutManagerProvider {
//
//        override fun get(context: Context): RecyclerView.LayoutManager {
//            return StaggeredGridLayoutManager(mSpanCount, mOrientation)
//        }
//    }
}