package com.example.temp.features.events.domain.repository

import com.example.temp.features.events.domain.model.Event
import com.example.temp.network.Carry

interface EventsRepository {

    fun getEvents(carry: Carry<List<Event>>)
}