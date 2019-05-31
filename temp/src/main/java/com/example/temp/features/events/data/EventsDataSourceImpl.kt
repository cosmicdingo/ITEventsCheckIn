package com.example.temp.features.events.data

import com.example.temp.features.events.domain.model.Event
import com.example.temp.network.Carry
import com.example.temp.network.DefaultCallback

class EventsDataSourceImpl (private val eventApi: EventsApi) : EventsDataSource {
    override fun getEvents(carry: Carry<List<Event>>) {
        eventApi.getEvents("test").enqueue(DefaultCallback(carry))
    }
}