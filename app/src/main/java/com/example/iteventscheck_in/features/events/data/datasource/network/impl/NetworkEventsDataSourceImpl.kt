package com.example.iteventscheck_in.features.events.data.datasource.network.impl

import com.example.iteventscheck_in.features.events.data.api.EventsApi
import com.example.iteventscheck_in.features.events.data.datasource.network.NetworkEventsDataSource
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NetworkEventsDataSourceImpl(private val eventApi: EventsApi?) :
    NetworkEventsDataSource {
    override fun getEvents(): Observable<List<Event>> {
        return eventApi!!.getEvents("test")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}