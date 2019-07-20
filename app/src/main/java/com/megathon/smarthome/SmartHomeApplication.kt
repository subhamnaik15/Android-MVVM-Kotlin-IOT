package com.megathon.smarthome

import android.app.Application
import org.koin.android.ext.android.startKoin

class SmartHomeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin(this, listOf(loginModule,appliancesModule))
    }

}