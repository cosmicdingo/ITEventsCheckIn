package com.example.iteventscheck_in.features.events.data.datasource.local.impl

import com.example.iteventscheck_in.database.AppDatabase
import com.example.iteventscheck_in.features.events.data.datasource.local.LocalEventsDataSource
import com.example.iteventscheck_in.features.events.data.entity.CityEntity
import com.example.iteventscheck_in.features.events.data.entity.EventEntity
import io.reactivex.Maybe

class LocalEventsDataSourceImpl(val db: AppDatabase?) : LocalEventsDataSource {

    override fun getEvents(): Maybe<List<EventEntity>> {
        return db!!.eventDao().getAllEventsMaybe()
    }

    override fun getCities(): List<CityEntity> {
        return db!!.cityDao().getAllCities()
    }
}