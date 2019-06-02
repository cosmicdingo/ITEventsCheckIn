package com.example.iteventscheck_in.features.events.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iteventscheck_in.R
import com.example.iteventscheck_in.features.events.domain.model.Event

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val TAG = "MainActivity"

    private var eventRecyclerView: RecyclerView? = null
    private var eventAdapter: EventAdapter? = null

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        presenter = PresenterFactory.createPresenter(this)
    }

    private fun initUI() {

        eventRecyclerView = findViewById(R.id.recyclerView)
        var eventLayoutManager = LinearLayoutManager(this)
        eventRecyclerView!!.layoutManager = eventLayoutManager

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

        eventAdapter = EventAdapter(list)
        eventRecyclerView!!.adapter = eventAdapter
        Log.d(TAG, "events.length = ${list.size}")
    }
}
