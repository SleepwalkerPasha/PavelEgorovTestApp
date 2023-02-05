package ru.tinkoff.edu.popularfilms.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SingleMovieApi(
    @SerialName("countries")
    val countries: List<MovieApi.CountryApi>?,
    @SerialName("genres")
    val genres: List<MovieApi.GenreApi>?,
    @SerialName("kinopoiskId")
    val kinopoiskId: Int,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("posterUrl")
    val posterUrl: String,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerialName("year")
    val year: Int?,
    @SerialName("description")
    val description: String?
)
