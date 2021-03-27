package com.bebye.base.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = listOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.size

}