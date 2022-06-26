package com.abjt.apptheming.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abjt.apptheming.R
import com.abjt.apptheming.common.APP_THEME
import com.abjt.apptheming.common.PreferenceManager
import com.abjt.apptheming.common.Themes.DARK_THEME
import com.abjt.apptheming.common.Themes.LIGHT_THEME

open class BaseThemeActivity : AppCompatActivity() {

    protected lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PreferenceManager(applicationContext).run {
            preferenceManager = this
            initEditor()
            when (getString(APP_THEME)) {
                LIGHT_THEME.name -> setTheme(R.style.MyLightTheme)
                DARK_THEME.name -> setTheme(R.style.MyDarkTheme)
                else -> setTheme(R.style.MyLightTheme)
            }
        }
    }
}