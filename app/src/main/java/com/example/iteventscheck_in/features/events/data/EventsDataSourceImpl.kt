package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry
import com.example.iteventscheck_in.network.DefaultCallback
import io.reactivex.Observable

class EventsDataSourceImpl (private val eventApi: EventsApi?) : EventsDataSource {
    override fun getEvents(): Observable<List<Event>> {
        return eventApi!!.getEvents("test")
    }
}