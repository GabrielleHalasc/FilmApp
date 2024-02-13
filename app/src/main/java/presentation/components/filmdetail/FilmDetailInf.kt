package presentation.components.filmdetail

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.filmapp.R
import data.response.filmdetail.FilmDetails

@Composable
fun FilmInfContent(
    filmDetails: FilmDetails?,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        FilmDetailInf(
            name = stringResource(id = R.string.popularity),
            value = filmDetails?.popularity.toString()
        )

        FilmDetailInf(
            name = stringResource(id = R.string.release_date),
            value = filmDetails?.release.toString()
        )
    }


}

@Composable
 fun FilmDetailInf(
     name: String,
     value: String,
     modifier: Modifier = Modifier
 ){
    Column {
        Text(
            text = name,
            style = MaterialTheme
                .typography.bodySmall,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(4.dp)
        )
        Text(text = value,
            style = MaterialTheme
                .typography.bodySmall,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(4.dp))
    }

 }

@Preview(showBackground = true)
@Composable
fun FilmInfContentPreview(){
    FilmInfContent(
        filmDetails = FilmDetails(
             id = 1,
             title = "Filme",
            overview = null,
            popularity = 8.2,
            release = "2024",
            posterPath = null,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}