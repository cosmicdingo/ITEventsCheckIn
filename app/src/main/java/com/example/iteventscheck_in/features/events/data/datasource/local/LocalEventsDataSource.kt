package com.example.iteventscheck_in.features.events.data.datasource.local

import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.data.entity.EventsWithCities
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Completable
import io.reactivex.Maybe

interface LocalEventsDataSource {

    // кладем данные в бд
    fun putEventsInDatabase(eventsList: List<Event>): Completable

    fun getEventsWithCities(): Maybe<List<EventsWithCities>>
}