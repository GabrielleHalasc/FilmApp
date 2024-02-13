package presentation

import UtilFunctions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapp.ResultData
import domain.FilmDetailUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import presentation.state.filmdetail.FilmDetailState
import javax.inject.Inject

class FilmDetailViewModel @Inject constructor(
    private val getFilmDetailUseCase: FilmDetailUseCase
) : ViewModel() {


    var state by mutableStateOf(FilmDetailState())
        private set


    fun loadFilmDetail(params: FilmDetailUseCase.Params) {
        viewModelScope.launch {
            getFilmDetailUseCase.invoke(params)
                .collect { resultData ->
                    when (resultData) {
                        is ResultData.Success -> {
                            state = state.copy(
                                isLoading = false,
                                filmDetail = resultData.data?.second,
                                result = resultData.data?.first ?: emptyFlow()
                            )
                        }

                        is ResultData.Failure -> {
                            state = state.copy(
                                isLoading = false,
                                error = resultData.e?.message.toString()
                            )
                            UtilFunctions.logError(
                                "DETAIL_ERROR",
                                resultData.e?.message.toString()
                            )
                        }

                        is ResultData.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )

                        }
                    }


                }

        }
    }
}
