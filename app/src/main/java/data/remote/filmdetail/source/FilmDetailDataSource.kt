package data.remote.filmdetail.source

import data.response.filmdetail.FilmDetails

interface  FilmDetailDataSource{
    suspend fun getFilmDetail(movieId: Int): FilmDetails

}