package com.example.iteventscheck_in

import android.app.Application
import android.content.Context
import com.example.iteventscheck_in.database.AppDatabase
import com.example.iteventscheck_in.database.DatabaseProvider
import com.example.iteventscheck_in.network.RetrofitProvider
import io.reactivex.plugins.RxJavaPlugins

class App : Application() {

    private var retrofitProvider: RetrofitProvider? = null
    //private val db: AppDatabase? = null
    private var databaseProvider: DatabaseProvider? = null

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitProvider()
        databaseProvider = DatabaseProvider(applicationContext)
    }

    companion object {

        fun getRetrofitProvider(context: Context): RetrofitProvider? {
            return getApp(context).retrofitProvider
        }

        fun getDatabaseProvider(context: Context): DatabaseProvider? {
            return getApp(context).databaseProvider
        }

        private fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }
}