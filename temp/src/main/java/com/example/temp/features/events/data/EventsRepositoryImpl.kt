package com.example.temp.features.events.data

import com.example.temp.features.events.domain.model.Event
import com.example.temp.features.events.domain.repository.EventsRepository
import com.example.temp.network.Carry
import com.example.temp.network.DefaultCallback

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