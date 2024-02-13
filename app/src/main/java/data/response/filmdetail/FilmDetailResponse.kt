package data.response.filmdetail

import com.google.gson.annotations.SerializedName

data class FilmDetailResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_language")
    val language: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val country: String,

)