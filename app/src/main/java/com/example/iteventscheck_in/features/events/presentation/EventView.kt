package com.example.iteventscheck_in.features.events.presentation

import com.example.iteventscheck_in.features.BaseView
import com.example.iteventscheck_in.features.events.domain.model.Event


interface EventView : BaseView {
    fun showEventList(list: List<Event>)
}