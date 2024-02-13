package domain

import androidx.paging.PagingData
import com.example.filmapp.ResultData
import data.remote.filmdetail.repository.FilmDetailRepository
import data.remote.filmdetail.source.FilmDetailDataSource
import data.response.film.Film
import data.response.filmdetail.FilmDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


interface FilmDetailUseCase {
    operator fun invoke(params: Params): Flow<ResultData<Pair<Flow<PagingData<Film>>, FilmDetails>>>
    data class Params(val movieId: Int)
}

class FilmDetailUseCaseImp @Inject constructor(
    private val repository: FilmDetailRepository
) : FilmDetailUseCase {
    override fun invoke(params: FilmDetailUseCase.Params): Flow<ResultData<Pair<Flow<PagingData<Film>>, FilmDetails>>> {
        return flow {
            try {
                emit(ResultData.Loading)
                val filmDetails = repository.getFilmDetail(params.movieId)
            }catch (e : HttpException){
                emit(ResultData.Failure(e))
            }catch (e :IOException){
                emit(ResultData.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}
