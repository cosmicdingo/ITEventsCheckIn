package com.example.temp

import android.app.Application
import android.content.Context
import com.example.temp.network.RetrofitProvider

class App : Application() {

    private var retrofitProvider: RetrofitProvider? = null

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitProvider()
    }

    companion object {

        fun getRetrofitProvider(context: Context): RetrofitProvider? {
            return getApp(context).retrofitProvider
        }

        private fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }
}