package com.example.mvpsample.repository

interface LocalRepository {

    fun saveText(text:String)

    fun loadText(): String
}