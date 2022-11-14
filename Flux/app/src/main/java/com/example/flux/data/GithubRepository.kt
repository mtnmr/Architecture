package com.example.flux.data

import javax.inject.Inject


class GithubRepository @Inject constructor(private val githubService: GithubService) {

    fun getGithubRepos(user:String) = githubService.getGithubRepos(user)
}