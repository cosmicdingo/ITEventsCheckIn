package com.example.iteventscheck_in.features.events.domain.interactors

import androidx.lifecycle.LiveData
import com.example.iteventscheck_in.features.events.Take
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Observable

interface EventsInteractor {

    // получаем события с сервера при помощи Retrofit
    //fun getEvents(carry: Carry<List<Event>>)
    fun getEvents(): Observable<List<Event>>
    // достаем события из бд в случае отсутсвия интернета
    fun getEvents(take: Take<LiveData<List<Event>>>)
}