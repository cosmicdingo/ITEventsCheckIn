package com.example.temp.features

open interface MvpView {

    fun showProgress()

    fun hideProgress()

    fun showError(message: String?)
}