package com.example.iteventscheck_in.features.events.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.iteventscheck_in.R
import com.example.iteventscheck_in.features.events.domain.model.Event

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val TAG = "MainActivity"

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterFactory.createPresenter(this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun showError(message: String?) {
    }

    override fun showEventList(list: List<Event>) {

        Log.d(TAG, "events.length = ${list.size}")
    }
}
