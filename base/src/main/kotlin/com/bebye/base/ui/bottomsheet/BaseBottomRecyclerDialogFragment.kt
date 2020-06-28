package com.bebye.base.ui.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.bebye.base.R
import com.bebye.base.databinding.FragmentBottomRecyclerDialogBinding

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseBottomRecyclerDialogFragment : BaseBottomDialogFragment<FragmentBottomRecyclerDialogBinding>() {

    override var layoutResourceId = R.layout.fragment_bottom_recycler_dialog

    protected abstract fun createLayoutManager(): RecyclerView.LayoutManager

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(dataBinding.bottomDialogRecyclerView) {
            layoutManager = createLayoutManager()
            itemAnimator = DefaultItemAnimator()
        }
    }

}