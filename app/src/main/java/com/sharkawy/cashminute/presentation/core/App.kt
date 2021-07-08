package com.sharkawy.cashminute.presentation.core

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
    }
}