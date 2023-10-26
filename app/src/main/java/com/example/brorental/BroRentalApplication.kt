package com.example.brorental

import android.app.Application
import com.example.brorental.utils.SessionConfig


class BroRentalApplication:Application() {

    lateinit var sharedPref:SessionConfig
    override fun onCreate() {
        super.onCreate()

        sharedPref = SessionConfig(applicationContext)    }
    private fun initialize() {
        sharedPref = SessionConfig(applicationContext)
    }

}