package com.example.flux.flux

import com.example.flux.flux.action.Action
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Dispatcher @Inject constructor() {
    private val dispatcherProcessor: FlowableProcessor<Action<*>>
        = PublishProcessor.create<Action<*>>()

    fun <T> dispatch(action: Action<T>){
        dispatcherProcessor.onNext(action)
    }

    fun on(type:String) = dispatcherProcessor
        .filter{ it.type == type}
}