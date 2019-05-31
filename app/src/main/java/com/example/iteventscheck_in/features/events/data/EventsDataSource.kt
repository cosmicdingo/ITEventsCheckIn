package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry

interface EventsDataSource {
    fun getEvents(carry: Carry<List<Event>>)
}