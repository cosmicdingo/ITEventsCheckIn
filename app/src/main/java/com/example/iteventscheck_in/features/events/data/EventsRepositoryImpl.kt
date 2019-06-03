package com.example.iteventscheck_in.features.events.data

import androidx.lifecycle.LiveData
import com.example.iteventscheck_in.features.events.Take

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository



class EventsRepositoryImpl(
    private val dataSource: EventsDataSource
    //private val databaseProvider: DatabaseProvider
) : EventsRepository {
    override fun getEvents()  = dataSource.getEvents()

    override fun getEvents(take: Take<LiveData<List<Event>>>) {


        //val eventsEntityList = databaseProvider.db.eventDao().getAllEvents()

        /*var eventsEntityLiveData: LiveData<List<EventEntity>> = databaseProvider.db.eventDao().getAllEventsLiveData()

        var eventsLiveData: LiveData<List<Event>> = Transformations
            .switchMap(eventsEntityLiveData, Function {
                return@Function
            })*/

    }
}