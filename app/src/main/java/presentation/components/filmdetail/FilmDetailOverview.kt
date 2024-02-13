package presentation.components.filmdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmapp.R

@Composable
fun FilmDetailOverview(
    modifier: Modifier =Modifier,
    overview: String
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(
            id = R.string.description),
            color = Color.White,
            fontSize = 16.sp
        )
        if (expanded){
            Text(
                text = overview,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    expanded = !expanded
                }
            )
        }else{
            Text(
                text = overview,
                color = Color.White,
                fontSize = 16.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.clickable {
                    expanded = !expanded
                }
            )

        }
    }
}
@Preview
@Composable
fun FilmDetailOverviewPreview(){
    FilmDetailOverview(
        overview = "descriçao do filme",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    )
}
