package ru.tinkoff.edu.popularfilms.ui.fragments.entities

data class Movie(
    val nameRu: String?,
    val filmId: Int,
    val genres: List<Genre>?,
    val countries: List<Country>?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val year: Int?,
    val liked: Boolean = false,
)

data class Country(val country: String)

data class Genre(val genre: String)
