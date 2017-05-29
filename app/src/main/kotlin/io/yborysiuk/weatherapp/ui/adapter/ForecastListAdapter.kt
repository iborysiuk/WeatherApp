package io.yborysiuk.weatherapp.ui.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.yborysiuk.weatherapp.R
import io.yborysiuk.weatherapp.domain.model.Forecast
import io.yborysiuk.weatherapp.domain.model.ForecastList
import io.yborysiuk.weatherapp.extensions.ctx
import io.yborysiuk.weatherapp.extensions.toDateString
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size


    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}