package com.example.iteventscheck_in.features.events.presentation

import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(
    private val view: MainPresenter.View,
    private val interactor: EventsInteractor
) : MainPresenter {


    override fun onResume() {
        loadEvents()
    }

    private fun loadEvents() {
        view.showProgress()

        interactor.getEvents().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t: List<Event> -> view.showEventList(t) },
                { error -> error.printStackTrace() })
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}