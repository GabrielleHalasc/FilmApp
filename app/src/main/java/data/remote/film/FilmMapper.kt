package data.remote.film

import data.response.film.Film
import data.response.film.FilmResult

fun List<FilmResult>.toFilm() = map { filmResult ->
    Film(
        id = filmResult.id,
        title = filmResult.title,
        popularity = filmResult.popularity,
        imageUrl = filmResult.posterPath ?: ""
    )

}