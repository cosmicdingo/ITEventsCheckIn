package com.example.iteventscheck_in.features.events.data.datasource.impl

import com.example.iteventscheck_in.features.events.data.api.EventsApi
import com.example.iteventscheck_in.features.events.data.datasource.EventsDataSource
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Observable

class EventsDataSourceImpl(private val eventApi: EventsApi?) :
    EventsDataSource {
    override fun getEvents(): Observable<List<Event>> {
        return eventApi!!.getEvents("test")
    }
}