package com.example.iteventscheck_in.features.events.domain.repository

import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Observable

interface EventsRepository {

    fun getEvents(): Observable<List<Event>>
}