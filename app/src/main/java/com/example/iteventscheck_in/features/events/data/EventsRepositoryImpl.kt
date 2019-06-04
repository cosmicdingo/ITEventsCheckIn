package com.example.iteventscheck_in.features.events.data

import androidx.lifecycle.LiveData
import com.example.iteventscheck_in.features.events.data.datasource.EventsDataSource

import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import io.reactivex.Observable


class EventsRepositoryImpl(
    private val dataSource: EventsDataSource
    //private val databaseProvider: DatabaseProvider
) : EventsRepository {

    override fun getEvents() = dataSource.getEvents()
}