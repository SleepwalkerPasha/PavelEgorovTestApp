package ru.tinkoff.edu.popularfilms.api.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieApi(
    @SerialName("countries")
    val countries: List<Country>?,
    @SerialName("description")
    val description: String?,
    @SerialName("genres")
    val genres: List<Genre>?,
    @SerialName("kinopoiskId")
    val kinopoiskId: Int?,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("posterUrl")
    val posterUrl: String?,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String?,
    @SerialName("year")
    val year: Int?,
) {

    @Serializable
    data class Country(
        @SerialName("country")
        val country: String?
    )

    @Serializable
    data class Genre(
        @SerialName("genre")
        val genre: String?
    )
}