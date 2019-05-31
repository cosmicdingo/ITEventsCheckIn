package com.example.iteventscheck_in.features

interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(message: String?)
}