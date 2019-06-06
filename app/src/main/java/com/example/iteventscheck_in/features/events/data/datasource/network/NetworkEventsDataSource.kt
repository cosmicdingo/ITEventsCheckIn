package com.example.iteventscheck_in.features.events.data.datasource.network

import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry
import io.reactivex.Observable

interface NetworkEventsDataSource {
    fun getEvents(): Observable<List<Event>>
}