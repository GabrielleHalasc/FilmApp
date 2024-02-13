package presentation.state.filmdetail

import androidx.paging.PagingData
import data.response.film.Film
import data.response.filmdetail.FilmDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class FilmDetailState(
    val filmDetail: FilmDetails? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val result: Flow<PagingData<Film>> = emptyFlow()
)
