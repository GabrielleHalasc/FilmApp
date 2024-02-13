package presentation.state.film

import androidx.paging.PagingData
import data.response.film.Film
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class FilmState(
    val films: Flow<PagingData<Film>> = emptyFlow()
)