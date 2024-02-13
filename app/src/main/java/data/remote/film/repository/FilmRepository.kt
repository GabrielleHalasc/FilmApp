package data.remote.film.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import data.response.film.Film
import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getFilm(pagingConfig: PagingConfig): Flow<PagingData<Film>>
}
