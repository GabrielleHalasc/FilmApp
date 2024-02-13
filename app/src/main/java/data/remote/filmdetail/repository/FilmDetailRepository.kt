package data.remote.filmdetail.repository

import data.response.filmdetail.FilmDetails

interface FilmDetailRepository {
    suspend fun getFilmDetail(movieId: Int): FilmDetails
}