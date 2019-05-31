package com.example.temp.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun <T : MvpView> getPresenter(): MvpPresenter<T>

    protected abstract fun <T : MvpView> getMpvView(): T

    private var presenter: MvpPresenter<MvpView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = getPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter?.attachView(getMpvView())
    }

    override fun onStop() {
        super.onStop()
        presenter?.detachView()
    }
}