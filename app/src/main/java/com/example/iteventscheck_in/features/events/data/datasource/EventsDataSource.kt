package com.example.iteventscheck_in.features.events.data.datasource

import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry
import io.reactivex.Observable

interface EventsDataSource {
    fun getEvents(): Observable<List<Event>>
}