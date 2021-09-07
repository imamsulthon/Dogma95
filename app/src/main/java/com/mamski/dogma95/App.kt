package com.mamski.dogma95

import android.app.Application
import com.singhajit.sherlock.core.Sherlock
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    
    override fun onCreate() {
        super.onCreate()
        Sherlock.init(this)
    }

}