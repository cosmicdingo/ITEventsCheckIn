package com.example.temp.features.events.domain.model

class Event(
    val id: Int,
    val title: String,
    val city: List<City>,
    val description: String,
    val format: Int,
    val date: Date,
    val cardImage: String,
    val status: Int,
    val iconStatus: String,
    val eventFormat: String,
    val eventFormatEng: String
)