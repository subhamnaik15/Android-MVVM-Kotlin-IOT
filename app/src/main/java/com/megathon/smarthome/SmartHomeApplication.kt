package com.megathon.smarthome

import android.app.Application
import android.content.Context
import com.megathon.smarthome.network.RetrofitClient

class SmartHomeApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        val context: Context = applicationContext()
//        RetrofitClient.create(cacheDir)
    }

    companion object {
        private var instance: SmartHomeApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

    }


}