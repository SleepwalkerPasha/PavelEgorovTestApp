package ru.tinkoff.edu.popularfilms.api

import retrofit2.http.*
import ru.tinkoff.edu.popularfilms.api.entities.MovieApi
import ru.tinkoff.edu.popularfilms.api.entities.MoviePayloadApi

interface KinopoiskAPIServices {
    @Headers("X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    suspend fun getTop100MovieList(@Query("page") pageNum: Int): MoviePayloadApi

    @Headers("X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
    @GET("/api/v2.2/films/top/{id}")
    suspend fun getMovieInfo(@Path("id") id: Int): MovieApi
}