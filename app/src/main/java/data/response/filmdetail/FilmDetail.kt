package data.response.filmdetail

data class FilmDetails(
    val id: Int,
    val title: String,
    val overview: String?,
    val popularity: Double,
    val release: String,
    val posterPath: String?,
)