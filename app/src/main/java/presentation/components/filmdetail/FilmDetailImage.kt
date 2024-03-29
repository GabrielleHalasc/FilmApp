package presentation.components.filmdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.filmapp.R

@Composable
fun FilmDetailImage(
    imageUrl: String,
    modifier: Modifier
){
    Box(modifier = modifier){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .error(R.drawable.ic_error_image)
                .placeholder(R.drawable.movie_holder)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
           )
    }
}

@Preview
@Composable
fun FilmDetailImagePreview(){
    FilmDetailImage(
        imageUrl = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) )
}