package com.example.temp.features.events.data

import com.example.temp.features.events.domain.model.Event
import com.example.temp.network.Carry

interface EventsDataSource {
    fun getEvents(carry: Carry<List<Event>>)
}