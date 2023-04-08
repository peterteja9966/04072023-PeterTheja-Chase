package com.weather.chase.base

/**
 * Created by peterx.theja on 2023-04-06.
 */
import android.annotation.SuppressLint
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel

abstract class LifecycleViewModel : ViewModel(), LifecycleOwner {

    @SuppressLint("StaticFieldLeak")
    @Suppress("LeakingThis") //LifecycleRegistry holds a weak reference of the class
    private val lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    override fun onCleared() {
        super.onCleared()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

}