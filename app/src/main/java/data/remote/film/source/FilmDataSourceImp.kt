package data.remote.film.source

import data.remote.film.FilmService
import data.response.film.FilmResponse
import javax.inject.Inject

 class FilmDataSourceImp @Inject constructor(
    private val service: FilmService
): FilmDataSource {
     override suspend fun getFilmPagingSource(): FilmPagingSource {
         return FilmPagingSource(this)
     }

     override suspend fun getFilm(page: Int): FilmResponse {
         return service.getFilmPopular(page = page)
     }
 }

