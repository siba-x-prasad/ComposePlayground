package com.swasi.composeplayground.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}