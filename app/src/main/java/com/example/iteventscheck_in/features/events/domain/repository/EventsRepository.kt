package com.example.iteventscheck_in.features.events.domain.repository

import androidx.lifecycle.LiveData
import com.example.iteventscheck_in.features.events.Take
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Observable

interface EventsRepository {

    fun getEvents(): Observable<List<Event>>
    fun getEvents(take: Take<LiveData<List<Event>>>)

}