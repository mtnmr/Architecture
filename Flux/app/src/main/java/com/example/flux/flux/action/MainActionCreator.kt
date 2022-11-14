package com.example.flux.flux.action

import android.util.Log
import com.example.flux.data.GithubRepository
import com.example.flux.flux.Dispatcher
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainActionCreator @Inject constructor(
    private val dispatcher: Dispatcher,
    private val repository: GithubRepository
) {
    fun getRepos(user:String)
        = repository.getGithubRepos(user)
        .subscribeOn(Schedulers.io())
        .subscribeBy(
            onSuccess = {
                dispatcher.dispatch(MainAction.GetRepos(it))
            },
            onError = {
                Log.d("github api", "get repos error: $it")
            }
        )
}