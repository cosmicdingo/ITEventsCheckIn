package com.example.iteventscheck_in.features.events.domain.interactors.impl

import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import io.reactivex.Maybe

class EventsInteractorImpl(private val eventsRepository: EventsRepository) :
    EventsInteractor {

    override fun getEventsFromNetwork() = eventsRepository.getEventsFromNetwork()

    override fun putEventsInDatabase(eventsList: List<Event>) = eventsRepository.putEventsInDatabase(eventsList)

    override fun getEventsWithCitiesFromLocal(): Maybe<List<Event>> = eventsRepository.getEventsWithCitiesFromLocal()

}