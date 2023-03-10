package ru.tinkoff.edu.popularfilms.api.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieApi(
    @SerialName("countries")
    val countries: List<CountryApi>?,
    @SerialName("genres")
    val genres: List<GenreApi>?,
    @SerialName("filmId")
    val filmId: Int,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("posterUrl")
    val posterUrl: String,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerialName("year")
    val year: Int?,
) {
    @Serializable
    data class CountryApi(
        @SerialName("country")
        val country: String
    )

    @Serializable
    data class GenreApi(
        @SerialName("genre")
        val genre: String
    )
}