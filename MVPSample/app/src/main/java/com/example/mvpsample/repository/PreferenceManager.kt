package com.example.mvpsample.repository

import android.content.Context

const val SAVE_TEXT_KEY = "current text"

class PreferenceManager(context: Context) : LocalRepository {

    val sharedPref = context.getSharedPreferences("my_settings", Context.MODE_PRIVATE)

    override fun saveText(text: String) {
        sharedPref.edit().putString(SAVE_TEXT_KEY, text).apply()
    }

    override fun loadText(): String {
        return sharedPref.getString(SAVE_TEXT_KEY, "").toString()
    }
}