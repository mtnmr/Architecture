package com.example.flux.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    fun getGithubRepos(@Path("user") user:String): Single<List<Repo>>
}