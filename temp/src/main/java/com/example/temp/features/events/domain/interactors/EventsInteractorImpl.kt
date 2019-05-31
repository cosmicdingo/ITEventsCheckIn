package com.example.temp.features.events.domain.interactors

import com.example.temp.features.events.domain.model.Event
import com.example.temp.features.events.domain.repository.EventsRepository
import com.example.temp.network.Carry

class EventsInteractorImpl(private val eventsRepository: EventsRepository) : EventsInteractor {

    override fun getEvents(carry: Carry<List<Event>>) {
        eventsRepository.getEvents(carry)
    }
}