package com.example.iteventscheck_in.features.events.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iteventscheck_in.R
import com.example.iteventscheck_in.extensions.toConvertDate
import com.example.iteventscheck_in.features.events.domain.model.Event
import com.squareup.picasso.Picasso

class EventAdapter(private val eventList: List<Event>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val BASE_URL = "https://team.cft.ru/"
    private val TAG = "EventAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_item, parent, false)
        return ViewHolder(cardView)
    }

    override fun getItemCount() = eventList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        onBind(cardView, position)
    }

    private fun onBind(cardView: View, position: Int) {

        val imageView: ImageView = cardView.findViewById(R.id.cardImage)
        Picasso
            .get()
            .load(BASE_URL + eventList[position].cardImage)
            .into(imageView)

        val tvDate: TextView = cardView.findViewById(R.id.tvDate)
        tvDate.text = eventList[position].date.start
            .toConvertDate()

        val tvCity: TextView = cardView.findViewById(R.id.tvCity)
        tvCity.text = eventList[position].cities[0].nameRus

        val tvTitle: TextView = cardView.findViewById(R.id.tvTitle)
        tvTitle.text = eventList[position].title

        val tvDescription: TextView = cardView.findViewById(R.id.tvDescription)
        tvDescription.text = eventList[position].description
    }

    inner class ViewHolder(var cardView: View) : RecyclerView.ViewHolder(cardView)
}