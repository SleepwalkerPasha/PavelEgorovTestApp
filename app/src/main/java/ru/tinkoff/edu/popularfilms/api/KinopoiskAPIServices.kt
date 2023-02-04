package ru.tinkoff.edu.popularfilms.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.tinkoff.edu.popularfilms.api.entities.MovieApi

interface KinopoiskAPIServices {

    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    suspend fun getTop100MovieList(@Query("page") pageNum: Int): MutableList<MovieApi>

    @GET("/api/v2.2/films/top/{id}")
    suspend fun getMovieInfo(@Path("id") id: Int): MovieApi
}