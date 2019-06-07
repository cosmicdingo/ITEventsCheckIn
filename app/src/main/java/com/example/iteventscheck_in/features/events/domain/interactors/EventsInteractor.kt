package com.example.iteventscheck_in.features.events.domain.interactors

import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable

interface EventsInteractor {

    // получаем события с сервера при помощи Retrofit
    fun getEventsFromNetwork(): Observable<List<Event>>
    // кладем данные в бд
    fun putEventsInDatabase(eventsList: List<Event>): Completable
    // достаем события из бд в случае отсутсвия интернета
    fun getEventsWithCitiesFromLocal(): Maybe<List<Event>>
}