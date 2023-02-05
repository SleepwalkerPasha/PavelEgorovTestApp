package ru.tinkoff.edu.popularfilms.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SingleMovieApi(
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("kinopoiskId")
    val kinopoiskId: Int,
    @SerialName("genres")
    val genres: List<MovieApi.GenreApi>?,
    @SerialName("countries")
    val countries: List<MovieApi.CountryApi>?,
    @SerialName("posterUrl")
    val posterUrl: String,
    @SerialName("description")
    val description: String?,
    @SerialName("year")
    val year: Int?,
    var liked: Boolean = false,
)