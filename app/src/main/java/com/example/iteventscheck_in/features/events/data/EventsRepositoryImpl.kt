package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import com.example.iteventscheck_in.network.Carry
import com.example.iteventscheck_in.network.DefaultCallback

/*class EventsRepositoryImpl(private val dataSource: EventsDataSource) : EventsRepository {
    override fun getEvents(carry: Carry<List<Event>>) {
        dataSource.getEvents(carry)
    }

}*/

class EventsRepositoryImpl(private val eventApi: EventsApi?) : EventsRepository {
    override fun getEvents(carry: Carry<List<Event>>) {
        eventApi?.getEvents("cftte@mtest20!9")?.enqueue(DefaultCallback(carry))
    }
}