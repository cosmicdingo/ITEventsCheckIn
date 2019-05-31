package com.example.temp.features.events.presentation

import android.content.Context
import com.example.temp.App
import com.example.temp.features.events.data.EventsApi
import com.example.temp.features.events.data.EventsRepositoryImpl
import com.example.temp.features.events.domain.interactors.EventsInteractor
import com.example.temp.features.events.domain.interactors.EventsInteractorImpl
import com.example.temp.features.events.domain.repository.EventsRepository

class PresenterFactory {

    companion object Factory {
        fun createPresenter(context: Context): EventPresenter {
            val api: EventsApi? = App.getRetrofitProvider(context)
                ?.retrofit
                ?.create(EventsApi::class.java)

            val repository: EventsRepository = EventsRepositoryImpl(api)
            val interactor: EventsInteractor = EventsInteractorImpl(repository)

            return EventPresenter(interactor)
        }
    }
}