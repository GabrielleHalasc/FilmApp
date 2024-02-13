package data.response.film

import com.google.gson.annotations.SerializedName

data class FilmResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<FilmResult>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val language: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val release: String,
    @SerializedName("title")
    val title: String = ""
)
