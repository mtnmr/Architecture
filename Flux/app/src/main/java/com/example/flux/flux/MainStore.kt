package com.example.flux.flux

import com.example.flux.data.Repo
import com.example.flux.flux.action.MainAction
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import javax.inject.Inject

class MainStore @Inject constructor(private val dispatcher: Dispatcher) {

    private val _repos = BehaviorProcessor.create<List<Repo>>()
    val repos: Flowable<List<Repo>> = _repos

    init {
        dispatcher.on(MainAction.GetRepos.TYPE)
            .map { (it as MainAction.GetRepos).data }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_repos)
    }
}