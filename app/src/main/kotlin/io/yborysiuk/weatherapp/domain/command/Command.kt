package io.yborysiuk.weatherapp.domain.command

interface Command<T> {
    fun execute(): T
}
