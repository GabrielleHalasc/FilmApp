package data.response.film

import com.google.gson.annotations.SerializedName
import data.response.film.FilmResult

data class FilmResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<FilmResult>,
    @SerializedName("total_page")
    val totalPage: Int,
    @SerializedName("total_results")
    val totalResults: List<FilmResult>,


    )