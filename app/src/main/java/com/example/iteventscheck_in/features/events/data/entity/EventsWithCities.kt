package com.example.iteventscheck_in.features.events.data.entity

import androidx.room.Relation

data class EventsWithCities(
    val id: Int,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val cardImage: String,
    @Relation(parentColumn = "id", entityColumn = "event_id", entity = CityEntity::class)
    val cities: List<CityEntity>
)