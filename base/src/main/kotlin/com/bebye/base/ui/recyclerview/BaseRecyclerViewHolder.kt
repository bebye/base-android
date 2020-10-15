package com.bebye.base.ui.recyclerview

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mkwon on 27/06/2020.
 */
open class BaseRecyclerViewHolder<VB : ViewDataBinding, ITEM>(private val dataBinding: VB) : RecyclerView.ViewHolder(dataBinding.root) {

    @CallSuper
    open fun bind(itemBindingVariableId: Int, item: ITEM) {
        dataBinding.setVariable(itemBindingVariableId, item)
        dataBinding.executePendingBindings()
    }

}