package presentation.components.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import data.response.film.Film


@Composable
fun FilmContent(
    modifier: Modifier = Modifier,
    pagingFilms: LazyPagingItems<Film>,
    paddingValues: PaddingValues,
    onClick: (movieId: Int) -> Unit
) {
    Box(modifier = modifier.background(Color.Black)) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(3.dp),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            items(pagingFilms.itemCount){
                index ->
                val film = pagingFilms[index]
                film?.let{
                    FilmItem(
                        votePopularity = it.popularity,
                        imageUrl = it.imageUrl ,
                        id = it.id,
                        onClick = {movieId ->
                            onClick(movieId)
                        }
                    )
                }
            }
        }
    }
}