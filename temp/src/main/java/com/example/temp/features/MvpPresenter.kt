package com.example.temp.features

open class MvpPresenter<View : MvpView> {

    protected var view: View? = null

    fun attachView(view: View) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    protected open fun onViewReady() {}
}