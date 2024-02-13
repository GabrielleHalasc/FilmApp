package presentation.components.filmdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.response.filmdetail.FilmDetails

@Composable
fun FilmDetailContent(
    modifier: Modifier = Modifier,
    filmDetails: FilmDetails,
    paddingValues: PaddingValues,
    isLoading: Boolean,
    isError: String
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FilmDetailImage(
                imageUrl = filmDetails.posterPath.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            FilmInfContent(
                filmDetails = filmDetails,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            FilmDetailOverview(
                overview = filmDetails.overview.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            if (isError.isNotEmpty()){
                Text(text = isError,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
            if(isLoading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    color = Color.White
                )
            }

        }
    }
}

@Preview
@Composable
fun FilmDetailContentPreview() {
    FilmDetailContent(
        filmDetails = FilmDetails(
            id = 1,
            title = "Filme",
            overview = "uma descricao de filme",
            popularity = 8.2,
            release = "2024",
            posterPath = "",
        ),
        isError = "Error",
        isLoading = false,
        paddingValues = PaddingValues(10.dp)
    )
}

