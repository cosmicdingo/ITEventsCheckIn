package com.example.iteventscheck_in.features.events.domain.interactors.impl

import androidx.lifecycle.LiveData
import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository

class EventsInteractorImpl(private val eventsRepository: EventsRepository) :
    EventsInteractor {

    override fun getEvents() = eventsRepository.getEvents()

    /*override fun getEvents(take: Take<LiveData<List<Event>>>) {
        eventsRepository.getEvents(take)
    }*/

}