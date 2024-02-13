package data.remote.film.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import data.response.film.Film
import data.remote.film.source.FilmDataSource
import kotlinx.coroutines.flow.Flow

class FilmRepositoryImp constructor(
    private val remoteDataSource: FilmDataSource
): FilmRepository {
    override fun getFilm(pagingConfig: PagingConfig): Flow<PagingData<Film>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getFilmPagingSource()
            }
        ).flow
    }
}