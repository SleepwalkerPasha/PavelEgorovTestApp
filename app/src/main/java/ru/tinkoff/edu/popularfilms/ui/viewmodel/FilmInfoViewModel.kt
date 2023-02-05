package ru.tinkoff.edu.popularfilms.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.tinkoff.edu.popularfilms.converter.MovieConverter
import ru.tinkoff.edu.popularfilms.ui.entities.SingleMovie
import ru.tinkoff.edu.popularfilms.ui.service.PopularFilmsService

class FilmInfoViewModel : ViewModel(), CoroutineScope by MainScope() {

    private val movieConverter = MovieConverter()

    private val _movie = MutableLiveData<SingleMovie>()
    val movie: LiveData<SingleMovie> get() = _movie

    private val service: PopularFilmsService by lazy {
        PopularFilmsService()
    }

    private val api = service.api

    fun loadMovieById(id: Int) = launch {
        val singleMovieApi = api.getMovieInfo(id)
        _movie.value = movieConverter.convertSingleMovie(singleMovieApi)
    }
}