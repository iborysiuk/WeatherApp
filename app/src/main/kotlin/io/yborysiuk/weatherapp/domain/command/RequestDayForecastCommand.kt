package io.yborysiuk.weatherapp.domain.command

import io.yborysiuk.weatherapp.domain.datasource.ForecastProvider
import io.yborysiuk.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}