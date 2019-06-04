package com.example.iteventscheck_in.features.events.presentation.presenter

import com.example.iteventscheck_in.features.BasePresenter
import com.example.iteventscheck_in.features.BaseView
import com.example.iteventscheck_in.features.events.domain.model.Event

interface EventPresenter : BasePresenter {

    interface View : BaseView {
        fun showEventList(list: List<Event>)
    }
}