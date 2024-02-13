package presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.filmapp.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.FilmDetailUseCase
import domain.PopularFilmUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import presentation.state.film.FilmState
import javax.inject.Inject

@HiltViewModel
class FilmPopularViewModel @Inject constructor(
    getPopularFilmUseCase: PopularFilmUseCase,
    private val getFilmDetailUseCase: FilmDetailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FilmState())
    val state: StateFlow<FilmState>
        get() = _state


    init {
        val films = getPopularFilmUseCase.invoke()
            .cachedIn(viewModelScope)
        _state.value = FilmState(films)
    }

    private fun event(event: FilmDetailEvent) {
        when (event) {
            is FilmDetailEvent.GetFilmDetail -> {
                viewModelScope.launch {
                    getFilmDetailUseCase.invoke(
                        params = FilmDetailUseCase.Params(
                            movieId = event.movieId
                        )
                    )
                }
            }
        }
    }
}
