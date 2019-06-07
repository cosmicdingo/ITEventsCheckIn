package com.example.iteventscheck_in.features.events.domain.repository

import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable

interface EventsRepository {

    fun getEventsFromNetwork(): Observable<List<Event>>

    fun putEventsInDatabase(eventsList: List<Event>): Completable

    fun getEventsWithCitiesFromLocal(): Maybe<List<Event>>
}