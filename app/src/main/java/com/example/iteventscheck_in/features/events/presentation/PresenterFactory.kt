package com.example.iteventscheck_in.features.events.presentation

import android.content.Context
import com.example.iteventscheck_in.App
import com.example.iteventscheck_in.features.events.data.EventsApi
import com.example.iteventscheck_in.features.events.data.EventsDataSource
import com.example.iteventscheck_in.features.events.data.EventsDataSourceImpl
import com.example.iteventscheck_in.features.events.data.EventsRepositoryImpl
import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractorImpl
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository

class PresenterFactory {

    companion object Factory {
        fun createPresenter(context: Context): MainPresenterImpl {
            val api: EventsApi? = App.getRetrofitProvider(context)
                ?.retrofit
                ?.create(EventsApi::class.java)

            val dataSource: EventsDataSource = EventsDataSourceImpl(api)
            val repository: EventsRepository = EventsRepositoryImpl(dataSource)
            val interactor: EventsInteractor = EventsInteractorImpl(repository)

            return MainPresenterImpl(context as MainPresenter.View, interactor)
        }
    }
}