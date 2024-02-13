package data.remote.film.source

import data.remote.film.source.FilmPagingSource
import data.response.film.FilmResponse

interface FilmDataSource {

    suspend fun  getFilmPagingSource(): FilmPagingSource

    suspend fun getFilm(page: Int) : FilmResponse
}
