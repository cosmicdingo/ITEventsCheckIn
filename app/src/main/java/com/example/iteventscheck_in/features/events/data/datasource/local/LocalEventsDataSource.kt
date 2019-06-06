package com.example.iteventscheck_in.features.events.data.datasource.local

import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import io.reactivex.Maybe

interface LocalEventsDataSource {

    fun getEvents(): Maybe<List<EventEntity>>
    fun getCities(): List<CityEntity>
}