package com.sharkawy.cashminute.presentation.core

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import java.util.*

object LanguageUtil {
    fun getLocale(context: Context): Locale {
        return Locale(Locale.getDefault().language)
    }

    fun updateBaseContextLocale(context: Context): Context {
        val locale = getLocale(context)
        Locale.setDefault(locale)
        return updateResourcesLocale(context, locale)
    }

    fun updateAppLocale(context: Context) {
        val locale = getLocale(context)
        val resources: Resources = context.resources
        val dm: DisplayMetrics = resources.displayMetrics
        val config: Configuration = resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale)
        }
        resources.updateConfiguration(config, dm)
    }

    private fun updateResourcesLocale(context: Context, locale: Locale): Context {
        val configuration = context.resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale)
        }
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context.createConfigurationContext(configuration)
        } else {
            TODO("VERSION.SDK_INT < JELLY_BEAN_MR1")
        }
    }

}