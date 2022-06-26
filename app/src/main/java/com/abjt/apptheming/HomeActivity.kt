package com.abjt.apptheming

import android.content.Intent
import android.os.Bundle
import com.abjt.apptheming.base.BaseThemeActivity
import com.abjt.apptheming.common.APP_THEME
import com.abjt.apptheming.common.Themes.DARK_THEME
import com.abjt.apptheming.common.Themes.LIGHT_THEME
import com.abjt.apptheming.databinding.ActivityMainBinding

class HomeActivity : BaseThemeActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.tvLightTheme.setOnClickListener {
            preferenceManager.putString(APP_THEME, LIGHT_THEME.name)
            recreateHomeActivity()
        }
        binding.tvDarkTheme.setOnClickListener {
            preferenceManager.putString(APP_THEME, DARK_THEME.name)
            recreateHomeActivity()
        }
    }

    private fun recreateHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
        overridePendingTransition(0, 0)
    }
}