package com.bebye.base.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bebye.base.viewmodel.Event

/**
 * Created by mkwon on 27/06/2020.
 */
fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, func: (T) -> Unit) {
    observe(lifecycleOwner, Observer { func(it) })
}

fun <T> LiveData<Event<T>>.observeEvent(lifecycleOwner: LifecycleOwner, func: (T) -> Unit) {
    observe(lifecycleOwner, EventObserver { func(it) })
}

class EventObserver<T>(private val onEventUnHandledContent: (T) -> Unit) : Observer<Event<T>> {

    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.takeIf { it }?.let {
            onEventUnHandledContent(event.getContent())
        }
    }

}