package com.example.iteventscheck_in.features.events.domain.interactors

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry

interface EventsInteractor {

    fun getEvents(carry: Carry<List<Event>>)
}