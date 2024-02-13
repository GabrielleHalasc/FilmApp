package data.response.film

data class Film(
    val id: Int,
    val title: String,
    val popularity: Double = 0.0,
    val imageUrl: String = ""
)