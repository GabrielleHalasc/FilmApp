package presentation.components.film

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.filmapp.R
import com.example.filmapp.ui.theme.FilmAppTheme

@Composable
fun FilmItem(
    modifier: Modifier = Modifier,
    votePopularity: Double,
    imageUrl: String,
    id: Int,
    onClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        FilmPopularity(
            popularity = votePopularity,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .zIndex(2f)
                .padding(
                    start = 6.dp,
                    top = 8.dp
                )
                .background(Color.Black)
        )
        Card(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .height(200.dp)
                .padding(4.dp)
                .clickable {
                    onClick(id)
                },
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .error(R.drawable.ic_error_image)
                        .placeholder(R.drawable.movie_holder)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(100.dp)
                        .background(
                            Color.Black
                        )
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}

@Preview
@Composable
fun FilmItemPreview() {
    FilmAppTheme {
        FilmItem(
            votePopularity = 8.1,
            imageUrl = "",
            id = 1,
            onClick = {})
    }
}