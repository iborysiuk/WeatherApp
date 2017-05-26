package io.yborysiuk.weatherapp.domain.command

import io.yborysiuk.weatherapp.data.ForecastRequest
import io.yborysiuk.weatherapp.domain.mapper.ForecastDataMapper
import io.yborysiuk.weatherapp.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}
