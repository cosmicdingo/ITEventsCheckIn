package com.example.temp.features.events.presentation

import com.example.temp.features.MvpPresenter
import com.example.temp.features.events.domain.interactors.EventsInteractor
import com.example.temp.features.events.domain.model.Event
import com.example.temp.network.Carry

class EventPresenter(private val interactor: EventsInteractor) : MvpPresenter<EventView>() {

    override fun onViewReady() {
        super.onViewReady()
        loadEvents()
    }

    private fun loadEvents() {
        view?.showProgress()
        interactor.getEvents(object : Carry<List<Event>> {
            override fun onSuccess(result: List<Event>) {
                view?.showEventList(result)
                view?.hideProgress()
            }

            override fun onFailure(throwable: Throwable) {
                view?.hideProgress()
                view?.showError(throwable.message)
            }

        })
    }

}