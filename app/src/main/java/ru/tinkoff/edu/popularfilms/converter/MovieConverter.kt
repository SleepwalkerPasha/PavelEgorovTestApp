package ru.tinkoff.edu.popularfilms.converter

import ru.tinkoff.edu.popularfilms.api.entities.MovieApi
import ru.tinkoff.edu.popularfilms.api.entities.SingleMovieApi
import ru.tinkoff.edu.popularfilms.ui.entities.Country
import ru.tinkoff.edu.popularfilms.ui.entities.Genre
import ru.tinkoff.edu.popularfilms.ui.entities.Movie
import ru.tinkoff.edu.popularfilms.ui.entities.SingleMovie

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

    fun convertSingleMovie(singleMovieApi: SingleMovieApi): SingleMovie {
        return SingleMovie(
            nameRu = singleMovieApi.nameRu,
            kinopoiskId = singleMovieApi.kinopoiskId,
            genres = singleMovieApi.genres?.map(this::convertGenre),
            countries = singleMovieApi.countries?.map(this::convertCountry),
            posterUrl = singleMovieApi.posterUrl,
            description = singleMovieApi.description,
            year = singleMovieApi.year,
        )
    }

    private fun convertGenre(genre: MovieApi.GenreApi): Genre {
        return Genre(genre.genre)
    }

    private fun convertCountry(country: MovieApi.CountryApi): Country {
        return Country(country.country)
    }
}