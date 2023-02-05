package ru.tinkoff.edu.popularfilms.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.tinkoff.edu.popularfilms.api.entities.MovieApi
import ru.tinkoff.edu.popularfilms.converter.MovieConverter
import ru.tinkoff.edu.popularfilms.ui.service.PopularFilmsService
import ru.tinkoff.edu.popularfilms.ui.entities.Movie

class MovieViewModel : ViewModel(), CoroutineScope by MainScope() {

    private val movieConverter = MovieConverter()

    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>> get() = _movies



    private val service: PopularFilmsService by lazy {
        PopularFilmsService()
    }

    private val api = service.api

    fun loadTop100Movies() = launch {
        val movieApiMlist = mutableListOf<MovieApi>()
        for (i in 1..5) {
            val movieApiList = api.getTop100MovieList(i).films ?: emptyList()
            movieApiMlist.addAll(movieApiList)
        }
        _movies.value = movieApiMlist.map(movieConverter::convert).toMutableList()
    }

}