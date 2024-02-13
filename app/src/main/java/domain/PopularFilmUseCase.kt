package domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import data.response.film.Film
import data.remote.film.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface PopularFilmUseCase{
operator fun invoke() : Flow<PagingData<Film>>
}
class PopularFilmUseCaseImp @Inject constructor(
    private val repository: FilmRepository
) : PopularFilmUseCase  {
    override fun invoke(): Flow<PagingData<Film>> {
        return repository.getFilm(
            pagingConfig = PagingConfig(
                pageSize = 15,
                initialLoadSize = 15
            )
        )
    }
}