package com.example.mvpsample.repository.local

interface LocalRepository {

    fun saveText(text:String)

    fun loadText(): String
}