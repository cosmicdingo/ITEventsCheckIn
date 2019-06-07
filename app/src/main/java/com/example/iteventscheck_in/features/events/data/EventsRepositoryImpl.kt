package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.data.datasource.local.LocalEventsDataSource
import com.example.iteventscheck_in.features.events.data.datasource.network.NetworkEventsDataSource
import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.domain.model.City
import com.example.iteventscheck_in.features.events.domain.model.Date
import com.example.iteventscheck_in.features.events.domain.model.Event

import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class EventsRepositoryImpl(
    private val networkDataSource: NetworkEventsDataSource,
    private val localDataSource: LocalEventsDataSource
) : EventsRepository {

    override fun getEventsFromNetwork() = networkDataSource.getEvents()

    override fun getEventsWithCitiesFromLocal(): Maybe<List<Event>> {
        return localDataSource.getEventsWithCities()
            .map {
                it.map {
                    Event(
                        it.id,
                        it.title,
                        it.cities.map { City(it.cityId, it.nameRus) },
                        it.description,
                        Date(it.startDate, it.endDate),
                        it.cardImage
                    )
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    // кладем данные в бд
    override fun putEventsInDatabase(eventsList: List<Event>): Completable =
        localDataSource.putEventsInDatabase(eventsList)
}