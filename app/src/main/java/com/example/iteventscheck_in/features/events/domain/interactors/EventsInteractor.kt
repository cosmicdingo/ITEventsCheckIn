package com.example.iteventscheck_in.features.events.domain.interactors

import androidx.lifecycle.LiveData
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Maybe
import io.reactivex.Observable

interface EventsInteractor {

    // получаем события с сервера при помощи Retrofit
    //fun getEventsFromNetwork(carry: Carry<List<Event>>)
    fun getEventsFromNetwork(): Observable<List<Event>>
    // достаем события из бд в случае отсутсвия интернета
    fun getEventsFromLocal(): Maybe<List<Event>>
}