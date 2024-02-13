package data.remote.film

import data.response.filmdetail.FilmDetailResponse
import data.response.film.FilmResponse
import data.response.film.FilmResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmService {

    @GET("movie/popular")
    suspend fun getFilmPopular(
        @Query("page") page: Int
    ): FilmResponse

    @GET("movie/{movie_id}")
    suspend fun getFilm(
        @Path("movie_id") movieId: Int
    ): FilmDetailResponse
}