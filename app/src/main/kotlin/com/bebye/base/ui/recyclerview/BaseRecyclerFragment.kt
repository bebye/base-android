package com.bebye.base.ui.recyclerview

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.bebye.base.R
import com.bebye.base.databinding.FragmentRecyclerViewBinding
import com.bebye.base.ui.BaseFragment

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseRecyclerFragment : BaseFragment<FragmentRecyclerViewBinding>() {

    protected abstract fun createLayoutManager(): RecyclerView.LayoutManager

    override var layoutResourceId = R.layout.fragment_recycler_view

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataBinding.recyclerView.apply {
            layoutManager = createLayoutManager()
            itemAnimator = DefaultItemAnimator()
        }
    }

    protected fun setSwipeRefreshEnabled(enabled: Boolean) {
        dataBinding.swipeRefreshLayout.isEnabled = enabled
    }

}