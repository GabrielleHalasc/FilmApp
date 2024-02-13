package presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.example.filmapp.R
import com.example.filmapp.ui.theme.White
import presentation.components.film.FilmContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: FilmPopularViewModel
) {

    val viewState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name),
                        color = White) },)
        },
        content ={ paddingValues ->
            FilmContent(
                pagingFilms = viewState.films.,
                paddingValues = paddingValues,
                onClick = {movieId ->

                }
            )
        }
    )
}

