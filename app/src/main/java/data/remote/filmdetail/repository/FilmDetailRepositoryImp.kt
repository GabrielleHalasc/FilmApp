package data.remote.filmdetail.repository

import data.remote.filmdetail.source.FilmDetailDataSource
import data.response.filmdetail.FilmDetails
import javax.inject.Inject

class FilmDetailRepositoryImp @Inject constructor(
    private val data: FilmDetailDataSource
): FilmDetailRepository {

    override suspend fun getFilmDetail(movieId: Int): FilmDetails {
        return data.getFilmDetail(movieId = movieId )
    }
}