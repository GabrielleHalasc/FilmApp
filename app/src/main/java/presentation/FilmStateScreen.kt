package presentation

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.filmapp.R
import androidx.compose.ui.res.stringResource
import presentation.components.filmdetail.FilmDetailContent
import presentation.state.filmdetail.FilmDetailState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmStateScreen(
    id: Int?,
    state: FilmDetailState,
    getFilmDetail: (FilmDetailEvent.GetFilmDetail) -> Unit
) {

    LaunchedEffect(key1 = true){
        if (id != null){
            getFilmDetail(FilmDetailEvent.GetFilmDetail(id))
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.film_detail),
                        color = Color.White)
                },
                Modifier.background(Color.Black)
            )

            }
    ){
        FilmDetailContent(
            filmDetails = state.filmDetail!!,
            isError = state.error,
            paddingValues = it,
            isLoading = state.isLoading
        )
    }
}