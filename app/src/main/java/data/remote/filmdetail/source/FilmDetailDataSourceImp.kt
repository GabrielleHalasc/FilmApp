package data.remote.filmdetail.source

import data.remote.film.FilmService
import data.response.filmdetail.FilmDetails
import javax.inject.Inject

class FilmDetailDataSourceImp @Inject constructor(
    private val service: FilmService
) : FilmDetailDataSource {
    override suspend fun getFilmDetail(movieId: Int): FilmDetails {
        val response = service.getFilm(movieId)
        return FilmDetails(
            id = response.id,
            title = response.title,
            overview = response.overview,
            popularity = response.popularity,
            posterPath = response.posterPath
        )
    }
}