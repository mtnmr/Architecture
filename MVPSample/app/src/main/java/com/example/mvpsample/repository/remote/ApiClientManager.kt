package com.example.mvpsample.repository.remote

import com.example.mvpsample.retrofit.PokeApi
import com.example.mvpsample.retrofit.Pokemon

class ApiClientManager:RemoteRepository {

    override suspend fun getPoke(id: String): Pokemon {
       return PokeApi.retrofitService.getPokemon(id)
    }
}