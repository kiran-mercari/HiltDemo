package com.example.hiltdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HiltDemoApp : Application() {
    @Inject
    lateinit var welcome: Welcome
    override fun onCreate() {
        super.onCreate()
        welcome.printWelcome()
    }
}