package com.example.iteventscheck_in.features.events.data

import com.example.iteventscheck_in.features.events.data.datasource.local.LocalEventsDataSource
import com.example.iteventscheck_in.features.events.data.datasource.network.NetworkEventsDataSource
import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import com.example.iteventscheck_in.features.events.domain.model.City
import com.example.iteventscheck_in.features.events.domain.model.Date
import com.example.iteventscheck_in.features.events.domain.model.Event

import com.example.iteventscheck_in.features.events.domain.repository.EventsRepository
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class EventsRepositoryImpl(
    private val networkDataSource: NetworkEventsDataSource,
    private val localDataSource: LocalEventsDataSource
) : EventsRepository {

    override fun getEventsFromNetwork() = networkDataSource.getEvents()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!

    override fun getEventsFromLocal(): Maybe<List<Event>> {

        return localDataSource.getEvents()
            .map {
                convertEventsFromEntityToModel(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun convertEventsFromEntityToModel(eventsEntityList: List<EventEntity>): List<Event> {

        val citiesList: List<City> = covertCitiesFromEntityToModelList(localDataSource.getCities())
        return eventsEntityList.map {
            Event(
                it.id, it.title, citiesList, it.description,
                Date(it.startDate, it.endDate), it.cardImage
            )
        }
    }

    private fun covertCitiesFromEntityToModelList(citiesEntityList: List<CityEntity>): List<City> {
        return citiesEntityList.map {
            City(it.id, it.nameRus)
        }
    }


}