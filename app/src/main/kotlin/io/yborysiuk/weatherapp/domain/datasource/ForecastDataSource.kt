package io.yborysiuk.weatherapp.domain.datasource

import io.yborysiuk.weatherapp.domain.model.Forecast
import io.yborysiuk.weatherapp.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}