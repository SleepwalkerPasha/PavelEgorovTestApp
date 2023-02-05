package ru.tinkoff.edu.popularfilms.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviePayloadApi(
    @SerialName("pagesCount")
    val pagesCount: Int,
    @SerialName("films")
    val films: List<MovieApi>?
)