package com.example.temp.features.events.domain.interactors

import com.example.temp.features.events.domain.model.Event
import com.example.temp.network.Carry

interface EventsInteractor {

    fun getEvents(carry: Carry<List<Event>>)
}