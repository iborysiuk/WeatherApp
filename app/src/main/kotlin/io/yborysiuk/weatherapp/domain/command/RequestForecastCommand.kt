package io.yborysiuk.weatherapp.domain.command

import io.yborysiuk.weatherapp.domain.datasource.ForecastProvider
import io.yborysiuk.weatherapp.domain.model.ForecastList

class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}