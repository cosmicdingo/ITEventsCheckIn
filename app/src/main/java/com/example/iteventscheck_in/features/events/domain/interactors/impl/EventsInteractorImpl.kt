package com.example.iteventscheck_in.features.events.domain.interactors.impl

import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository

class EventsInteractorImpl(private val eventsRepository: EventsRepository) :
    EventsInteractor {

    override fun getEventsFromNetwork() = eventsRepository.getEventsFromNetwork()

    override fun getEventsFromLocal() = eventsRepository.getEventsFromLocal()

}