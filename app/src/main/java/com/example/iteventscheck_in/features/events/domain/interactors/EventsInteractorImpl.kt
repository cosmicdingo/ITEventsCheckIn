package com.example.iteventscheck_in.features.events.domain.interactors

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import com.example.iteventscheck_in.network.Carry

class EventsInteractorImpl(private val eventsRepository: EventsRepository) : EventsInteractor {

    override fun getEvents(carry: Carry<List<Event>>) {
        eventsRepository.getEvents(carry)
    }
}