package com.example.temp.features.events.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.temp.R
import com.example.temp.features.BaseActivity
import com.example.temp.features.MvpPresenter
import com.example.temp.features.MvpView


class EventActivity : BaseActivity(), EventView {


    private var presenter: EventPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
    }

    override fun getPresenter: MvpPresenter<EventView>() {
        presenter = PresenterFactory.createPresenter(this)
        return presenter
    }

    /*
    override fun <T : MvpView> getPresenter(): MvpPresenter<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : MvpView> getMpvView(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/
}
