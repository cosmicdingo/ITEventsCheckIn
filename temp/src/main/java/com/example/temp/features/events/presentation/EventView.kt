package com.example.temp.features.events.presentation

import com.example.temp.features.MvpView
import com.example.temp.features.events.domain.model.Event

interface EventView : MvpView {
    fun showEventList(list: List<Event>)
}
