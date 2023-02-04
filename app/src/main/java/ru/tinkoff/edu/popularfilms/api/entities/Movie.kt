package ru.tinkoff.edu.popularfilms.api.entities

import org.json.JSONArray
import retrofit2.http.Url
import java.time.Year

data class Movie(
    var nameRu: String? = null,
    var kinopoiskId: Int,
    var posterUrl: Url,
    var posterUrlReview: Url,
    var year: Year? = null,
    var genres: JSONArray,
    var countries: JSONArray,
    var description: String? = null
)