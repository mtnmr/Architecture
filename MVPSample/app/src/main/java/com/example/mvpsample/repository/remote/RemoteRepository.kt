package com.example.mvpsample.repository.remote

import com.example.mvpsample.retrofit.Pokemon

interface RemoteRepository {
    suspend fun getPoke(id:String): Pokemon
}