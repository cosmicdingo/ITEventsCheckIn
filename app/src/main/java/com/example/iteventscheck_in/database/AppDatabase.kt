package com.example.iteventscheck_in.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.iteventscheck_in.features.events.data.dao.EventDao
import com.example.iteventscheck_in.features.events.data.entity.EventEntity

@Database(entities = [EventEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}