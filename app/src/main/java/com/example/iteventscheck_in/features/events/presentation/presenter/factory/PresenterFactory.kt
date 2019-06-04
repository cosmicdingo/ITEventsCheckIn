package com.example.iteventscheck_in.features.events.presentation.presenter.factory

import android.content.Context
import com.example.iteventscheck_in.App
import com.example.iteventscheck_in.features.events.data.api.EventsApi
import com.example.iteventscheck_in.features.events.data.datasource.EventsDataSource
import com.example.iteventscheck_in.features.events.data.datasource.impl.EventsDataSourceImpl
import com.example.iteventscheck_in.features.events.data.EventsRepositoryImpl
import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.interactors.impl.EventsInteractorImpl
import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import com.example.iteventscheck_in.features.events.presentation.presenter.EventPresenter
import com.example.iteventscheck_in.features.events.presentation.presenter.impl.EventPresenterImpl

class PresenterFactory {

    companion object Factory {
        fun createPresenter(context: Context): EventPresenterImpl {
            val api: EventsApi? = App.getRetrofitProvider(context)
                ?.retrofit
                ?.create(EventsApi::class.java)

            val dataSource: EventsDataSource =
                EventsDataSourceImpl(api)
            val repository: EventsRepository = EventsRepositoryImpl(dataSource)
            val interactor: EventsInteractor =
                EventsInteractorImpl(repository)

            return EventPresenterImpl(
                context as EventPresenter.View,
                interactor
            )
        }
    }
}