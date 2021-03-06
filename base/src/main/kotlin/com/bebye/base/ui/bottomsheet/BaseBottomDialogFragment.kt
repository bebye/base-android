package com.bebye.base.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.bebye.base.extension.getDisplayHeight
import com.bebye.base.utils.AutoLifecycleObserver
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseBottomDialogFragment<VB : ViewDataBinding> : BottomSheetDialogFragment() {

    abstract val fragmentTag: String

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    protected lateinit var dataBinding: VB

    private val autoLifeCycleObserver by lazy { AutoLifecycleObserver(lifecycle) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoLifeCycleObserver.init(this)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    protected fun setBottomSheetMinimumHeight(topMargin: Int) {
        val minimumPeekHeight = requireActivity().getDisplayHeight() - topMargin
        view?.viewTreeObserver?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                dialog?.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)?.let {
                    dataBinding.root.minimumHeight = minimumPeekHeight
                    BottomSheetBehavior.from(it).peekHeight = minimumPeekHeight
                }
            }
        })
    }

    fun show(fragmentManager: FragmentManager) {
        show(fragmentManager, fragmentTag)
    }

}