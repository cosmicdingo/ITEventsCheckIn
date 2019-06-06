package com.example.iteventscheck_in.features.events.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import io.reactivex.Maybe

@Dao
interface EventDao {

    @Query("SELECT * FROM EventEntity")
    fun getAllEvents(): List<EventEntity>

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    fun getEventById(id: Int): EventEntity

    @Query("SELECT * FROM EventEntity")
    fun getAllEventsLiveData(): LiveData<List<EventEntity>>

    @Query("SELECT * FROM EventEntity")
    fun getAllEventsMaybe(): Maybe<List<EventEntity>>

    @Insert
    fun insertEvents(vararg events: EventEntity)
}