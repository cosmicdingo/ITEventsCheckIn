package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.domain.model.Event
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsApi {

    @GET("api/v1/Events/registration?")
    fun getEvents(@Query("token=") token: String): Call<List<Event>>
}