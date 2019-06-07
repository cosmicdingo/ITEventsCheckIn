package com.example.iteventscheck_in.features.events.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.data.entity.EventsWithCities
import io.reactivex.Maybe

@Dao
interface EventDao {

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    fun getEventById(id: Int): EventEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEvents(eventsEntityList: List<EventEntity>)

    @Transaction
    @Query("SELECT id, title, description, start_date AS startDate, end_date AS endDate, card_image AS cardImage FROM EventEntity")
    fun getAllEventsWithCitiesMaybe():Maybe<List<EventsWithCities>>
}