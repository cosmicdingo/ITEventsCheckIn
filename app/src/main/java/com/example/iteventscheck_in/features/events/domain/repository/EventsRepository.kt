package com.example.iteventscheck_in.features.events.domain.repository

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry

interface EventsRepository {

    fun getEvents(carry: Carry<List<Event>>)
}