package ru.tinkoff.edu.popularfilms.ui.entities

data class SingleMovie (
    val nameRu: String?,
    val kinopoiskId: Int,
    val genres: List<Genre>?,
    val countries: List<Country>?,
    val posterUrl: String,
    val description: String?,
    val year: Int?,
    var liked: Boolean = false,
)