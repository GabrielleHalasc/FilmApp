package data.remote.film.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import data.response.film.Film
import data.remote.film.toFilm
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FilmPagingSource @Inject constructor(
    private val remoteData: FilmDataSource
) : PagingSource<Int, Film>() {

    override fun getRefreshKey(state: PagingState<Int, Film>): Int? {
        return state.anchorPosition?.let { anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(limit) ?: anchorPage?.nextKey?.minus(limit)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Film> {
        return try {

            val pageNumber = params.key ?: 1
            val response = remoteData.getFilm(page = pageNumber)
            val films = response.results

            LoadResult.Page(
                data = films.toFilm(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (films.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: IOException){
            exception.printStackTrace()
            return LoadResult.Error(exception)
        } catch (exception: HttpException){
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }
    }

    companion object{
        private const val limit = 15
    }
}