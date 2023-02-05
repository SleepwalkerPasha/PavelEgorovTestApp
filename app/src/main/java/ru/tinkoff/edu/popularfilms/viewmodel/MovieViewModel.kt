package ru.tinkoff.edu.popularfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.tinkoff.edu.popularfilms.converter.MovieConverter
import ru.tinkoff.edu.popularfilms.ui.PopularFilmsService
import ru.tinkoff.edu.popularfilms.ui.fragments.entities.Movie

class MovieViewModel : ViewModel(), CoroutineScope by MainScope() {

    private val movieConverter = MovieConverter()

    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>> get() = _movies

    private val service: PopularFilmsService by lazy {
        PopularFilmsService()
    }

    private val api = service.api

    fun loadTop100Movies() = launch {
        delay(1000)
        val movieApiList = api.getTop100MovieList(1).films ?: emptyList()
        _movies.value = movieApiList.map(movieConverter::convert).toMutableList()
    }
}