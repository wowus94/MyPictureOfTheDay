package com.example.mypictureoftheday.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mypictureoftheday.R
import com.example.mypictureoftheday.view.picture.PictureOfTheDayFragment

const val MainTheme = 1
const val MyGreenTheme = 2
const val MyRedTheme = 3

class MainActivity : AppCompatActivity() {
    private val KEY_SP = "sp"
    private val KEY_CURRENT_THEME = "current_theme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.MyGreenTheme)
        setTheme(getRealStyle(getCurrentTheme()))

        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }
    }


    fun setCurrentTheme(currentTheme: Int) {
        val sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_CURRENT_THEME, currentTheme)
        editor.apply()
    }

    fun getCurrentTheme(): Int {
        val sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE)
        return sharedPreferences.getInt(KEY_CURRENT_THEME, -1)
    }

    private fun getRealStyle(currentTheme: Int): Int {
        return when (currentTheme) {
            MainTheme -> R.style.MainTheme
            MyGreenTheme -> R.style.MyGreenTheme
            MyRedTheme -> R.style.MyRedTheme
            else -> 0
        }
    }

}


