package com.example.iteventscheck_in.features.events.data.datasource.local.impl

import com.example.iteventscheck_in.database.AppDatabase
import com.example.iteventscheck_in.features.events.data.datasource.local.LocalEventsDataSource
import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.data.entity.EventsWithCities
import com.example.iteventscheck_in.features.events.domain.model.Event
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalEventsDataSourceImpl(val db: AppDatabase?) : LocalEventsDataSource {


    override fun putEventsInDatabase(eventsList: List<Event>): Completable {
        return Completable.fromAction {
            putEvents(eventsList)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun putEvents(eventsList: List<Event>) {

        db!!.eventDao().insertEvents(
            eventsList.map {
                EventEntity(it.id, it.title, it.description, it.date.start, it.date.end, it.cardImage)
            })

        for (event in eventsList) {
            db.cityDao().insertCities(
                event.cities.map {
                    CityEntity(event.id, it.nameRus, it.id)
                }
            )
        }
    }

    override fun getEventsWithCities(): Maybe<List<EventsWithCities>> {
        return db!!.eventDao().getAllEventsWithCitiesMaybe()
    }
}