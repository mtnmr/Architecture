package com.example.flux.data

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    fun getGithubRepos(@Path("user") user:String): List<Repo>
}