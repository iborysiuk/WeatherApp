package io.yborysiuk.weatherapp

import android.app.Application
import io.yborysiuk.weatherapp.extensions.DelegatesExt.notNullSingleValue

class WeatherApp : Application() {

    companion object {
        var instance: WeatherApp by notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}