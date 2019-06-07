package com.example.iteventscheck_in.features.events.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iteventscheck_in.features.events.data.entity.CityEntity

@Dao
interface CityDao {

    @Query("SELECT * FROM CityEntity")
    fun getAllCities(): List<CityEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCities(citiesEntityList: List<CityEntity>)
}