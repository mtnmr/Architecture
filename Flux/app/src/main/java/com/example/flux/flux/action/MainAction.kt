package com.example.flux.flux.action

import com.example.flux.data.Repo

sealed class MainAction<out T>(override val type: String) :Action<T> {
    class GetRepos(override val data: List<Repo>):MainAction<List<Repo>>(TYPE){
        companion object{
            const val TYPE = "MainAction.GetRepos"
        }
    }
}