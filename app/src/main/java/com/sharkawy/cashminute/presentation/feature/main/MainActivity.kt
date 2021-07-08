package com.sharkawy.cashminute.presentation.feature.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.sharkawy.cashminute.R
import com.sharkawy.cashminute.presentation.core.LanguageUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(newBase: Context) {
        val context = LanguageUtil.updateBaseContextLocale(newBase)
        LanguageUtil.updateAppLocale(context)
        super.attachBaseContext(context)
    }
}