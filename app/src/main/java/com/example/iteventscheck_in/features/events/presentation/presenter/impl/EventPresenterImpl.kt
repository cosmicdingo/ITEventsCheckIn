package com.example.iteventscheck_in.features.events.presentation.presenter.impl

import android.annotation.SuppressLint
import android.util.Log
import com.example.iteventscheck_in.features.events.domain.interactors.EventsInteractor
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.example.iteventscheck_in.features.events.presentation.presenter.EventPresenter

class EventPresenterImpl(
    private val view: EventPresenter.View,
    private val interactor: EventsInteractor
) : EventPresenter {

    val TAG = "EventPresenter"
    override fun onResume() {
        loadEvents()
    }

    @SuppressLint("CheckResult")
    private fun loadEvents() {
        view.showProgress()

        interactor.getEventsFromNetwork().subscribe(
            { t: List<Event> ->
                view.showEventList(t)
                interactor.putEventsInDatabase(t)
                    .subscribe(
                        { Log.d(TAG, "events added id database") },
                        { error ->
                            error.printStackTrace()
                            Log.d(TAG, "events are not added id database")
                        }
                    )
            },
            { error ->
                error.printStackTrace()
                Log.d(TAG, "no internet connection")
                interactor.getEventsWithCitiesFromLocal().subscribe(
                    { t: List<Event> ->
                        Log.d(TAG, "events  database")
                        view.showEventList(t)
                    },
                    { t: Throwable -> t.printStackTrace() }
                )
            },
            {
                Log.d(TAG, "onComplete")
            })
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}