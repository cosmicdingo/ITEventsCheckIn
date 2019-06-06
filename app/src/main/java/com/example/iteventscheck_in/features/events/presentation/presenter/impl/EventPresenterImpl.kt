package com.example.iteventscheck_in.features.events.presentation.presenter.impl

import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.presentation.presenter.EventPresenter

class EventPresenterImpl(
    private val view: EventPresenter.View,
    private val interactor: EventsInteractor
) : EventPresenter {


    override fun onResume() {
        loadEvents()
    }

    private fun loadEvents() {
        view.showProgress()

        interactor.getEventsFromNetwork().subscribe(
            { t: List<Event> -> view.showEventList(t) },
            { error -> error.printStackTrace() },
            {
                interactor.getEventsFromLocal().subscribe(
                    { t: List<Event> -> view.showEventList(t) },
                    { t: Throwable -> t.printStackTrace() }
                )
            })
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}