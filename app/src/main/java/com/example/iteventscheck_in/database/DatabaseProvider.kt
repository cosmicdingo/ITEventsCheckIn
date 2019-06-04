package com.example.iteventscheck_in.database

import android.content.Context
import androidx.room.Room

class DatabaseProvider(context: Context) {

    public val db: AppDatabase

    init {
        db = Room.databaseBuilder(context, AppDatabase::class.java, "Event Database").build()
    }
}