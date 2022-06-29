package com.abjt.apptheming

import android.content.Intent
import android.os.Bundle
import com.abjt.apptheming.base.BaseThemeActivity
import com.abjt.apptheming.common.APP_THEME
import com.abjt.apptheming.common.Themes
import com.abjt.apptheming.common.Themes.*
import com.abjt.apptheming.databinding.ActivityMainBinding

class HomeActivity : BaseThemeActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setThemeName()
        setClickListeners()
    }

    private fun setThemeName() {
        binding.tvThemeName.text = preferenceManager.getString(APP_THEME)
    }

    private fun setClickListeners() {
        binding.tvLightTheme.setOnClickListener {
            saveAndRestart(LIGHT_THEME.name)
        }
        binding.tvDarkTheme.setOnClickListener {
            saveAndRestart(DARK_THEME.name)
        }
        binding.tvDarkBlueTheme.setOnClickListener {
            saveAndRestart(DARK_BLUE_THEME.name)
        }
        binding.tvDimLightTheme.setOnClickListener {
            saveAndRestart(DIM_LIGHT_THEME.name)
        }
    }

    private fun saveAndRestart(themeName: String) {
        preferenceManager.putString(APP_THEME, themeName).also {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            overridePendingTransition(0, 0)
        }
    }
}