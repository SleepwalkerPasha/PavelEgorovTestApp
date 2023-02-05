package ru.tinkoff.edu.popularfilms.converter

import ru.tinkoff.edu.popularfilms.api.entities.MovieApi
import ru.tinkoff.edu.popularfilms.ui.fragments.entities.Country
import ru.tinkoff.edu.popularfilms.ui.fragments.entities.Genre
import ru.tinkoff.edu.popularfilms.ui.fragments.entities.Movie

class MovieConverter {
    fun convert(movieApi: MovieApi): Movie {
        return Movie(
            nameRu = movieApi.nameRu,
            filmId = movieApi.filmId,
            genres = movieApi.genres?.map(this::convertGenre),
            countries = movieApi.countries?.map(this::convertCountry),
            posterUrl = movieApi.posterUrl,
            posterUrlPreview = movieApi.posterUrlPreview,
            year = movieApi.year,
        )
    }

    private fun convertGenre(genre: MovieApi.GenreApi): Genre {
        return Genre(genre.genre)
    }

    private fun convertCountry(country: MovieApi.CountryApi): Country {
        return Country(country.country)
    }
}