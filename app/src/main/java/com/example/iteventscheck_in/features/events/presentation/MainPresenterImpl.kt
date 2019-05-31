package com.example.iteventscheck_in.features.events.presentation

import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.network.Carry

class MainPresenterImpl(
    private val view: MainPresenter.View,
    private val interactor: EventsInteractor
) : MainPresenter {


    override fun onResume() {

        loadEvents();
    }

    private fun loadEvents() {
        view.showProgress()

        interactor.getEvents(object : Carry<List<Event>> {
            override fun onSuccess(result: List<Event>) {
                view.hideProgress()
                view.showEventList(result)
            }

            override fun onFailure(throwable: Throwable) {
                view.hideProgress()
                view.showError(throwable.message)
            }

        })
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}