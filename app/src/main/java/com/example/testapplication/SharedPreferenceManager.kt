package com.example.testapplication

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class SharedPreferenceManager(context : Context) {
    private val preference = context.getSharedPreferences(context.packageName,Context.MODE_PRIVATE)
    private val editor = preference.edit()
    private val keyTheme = "theme"

    var theme
        get() = preference.getInt(keyTheme,2)
        set(value) {
            editor.putInt(keyTheme,value)
            editor.commit()
        }

    val themeFlag = arrayOf(
        AppCompatDelegate.MODE_NIGHT_NO,
        AppCompatDelegate.MODE_NIGHT_YES,
        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    )
}