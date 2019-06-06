package com.example.iteventscheck_in.features.events.data.api

import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsApi {

    @GET("api/v1/Events/registration?")
    //fun getEventsFromNetwork(@Query("token=") token: String): Call<List<Event>>
    fun getEvents(@Query("token=") token: String): Observable<List<Event>>
}