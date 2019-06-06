package com.example.iteventscheck_in.features.events.domain.repository

import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Maybe
import io.reactivex.Observable

interface EventsRepository {

    fun getEventsFromNetwork(): Observable<List<Event>>
    fun getEventsFromLocal(): Maybe<List<Event>>
}