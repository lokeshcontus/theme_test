package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private val themeTitleList = arrayOf("Light","Dark","Auto (System Default)")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val changeThemeButton = findViewById<Button>(R.id.changeThemeButton)
        val themetxt = findViewById<TextView>(R.id.themetxt)


        val sharedPreferenceManager = SharedPreferenceManager(this)
        var checkedTheme = sharedPreferenceManager.theme
        themetxt.text = "Theme : ${themeTitleList[sharedPreferenceManager.theme]}"
        val themeDialog = MaterialAlertDialogBuilder(this)
            .setTitle("Theme")
            .setPositiveButton("OK"){_,_->
                sharedPreferenceManager.theme = checkedTheme
                AppCompatDelegate.setDefaultNightMode(sharedPreferenceManager.themeFlag[checkedTheme])
                themetxt.text = "Theme : ${themeTitleList[sharedPreferenceManager.theme]}"
            }
            .setSingleChoiceItems(themeTitleList,checkedTheme){_,which ->
                checkedTheme = which
            }
            .setCancelable(false)

        changeThemeButton.setOnClickListener{
            themeDialog.show()
        }
    }
}