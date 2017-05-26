package io.yborysiuk.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.yborysiuk.weatherapp.R
import io.yborysiuk.weatherapp.domain.command.RequestForecastCommand
import io.yborysiuk.weatherapp.ui.adapter.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("M1W 2N7").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }

}
