package com.example.flux.data

import com.squareup.moshi.Json

data class Repo (
    val id : Int,
    val name : String,
    @Json(name = "full_name") val fullName : String,
    @Json(name = "html_url") val htmlUrl : String,
    val description : String? = "",
)