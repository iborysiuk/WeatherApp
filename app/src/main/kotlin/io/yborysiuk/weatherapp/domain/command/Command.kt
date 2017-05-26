package io.yborysiuk.weatherapp.domain.command

interface Command<out T> {
    fun execute(): T
}
