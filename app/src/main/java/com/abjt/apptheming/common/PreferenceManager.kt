package com.abjt.apptheming.common

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(private val context: Context) {

    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    @Synchronized
    fun initEditor(): SharedPreferences? {
        sharedPreferences?.let { instance ->
            return instance
        } ?: let {
            sharedPreferences =
                context.getSharedPreferences(APP_SHARED_PREFERENCE, Context.MODE_PRIVATE)
            editor = sharedPreferences?.edit()
            return sharedPreferences
        }
    }

    fun putString(key: String, value: String) = editor?.run {
        this.putString(key, value)
        this.apply()
    }

    fun getString(key: String) = sharedPreferences?.getString(key, "")

    fun clearPreference() = editor?.run {
        this.clear()
        this.apply()
    }
}