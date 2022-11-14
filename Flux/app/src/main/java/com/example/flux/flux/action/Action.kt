package com.example.flux.flux.action

interface Action<out T> {
    val type:String
    val data:T
}