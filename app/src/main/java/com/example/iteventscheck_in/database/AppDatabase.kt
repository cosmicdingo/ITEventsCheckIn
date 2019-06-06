package com.example.iteventscheck_in.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.iteventscheck_in.features.events.data.dao.CityDao
import com.example.iteventscheck_in.features.events.data.dao.EventDao
import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity

@Database(entities = [EventEntity::class, CityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun cityDao(): CityDao
}