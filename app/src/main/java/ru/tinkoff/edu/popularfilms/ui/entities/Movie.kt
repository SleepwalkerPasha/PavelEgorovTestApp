package ru.tinkoff.edu.popularfilms.ui.entities

data class Movie(
    val nameRu: String?,
    val filmId: Int,
    val genres: List<Genre>?,
    val countries: List<Country>?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val year: Int?,
    var liked: Boolean = false,
)

data class Country(val country: String)

data class Genre(val genre: String)
