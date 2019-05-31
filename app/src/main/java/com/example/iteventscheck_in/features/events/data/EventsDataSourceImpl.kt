package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry
import com.example.iteventscheck_in.network.DefaultCallback

class EventsDataSourceImpl (private val eventApi: EventsApi) : EventsDataSource {
    override fun getEvents(carry: Carry<List<Event>>) {
        eventApi.getEvents("test").enqueue(DefaultCallback(carry))
    }
}