package data.remote.film

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.remote.film.repository.FilmRepository
import data.remote.film.repository.FilmRepositoryImp
import data.remote.film.source.FilmDataSource
import data.remote.film.source.FilmDataSourceImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilmModule {

@Provides
@Singleton
    fun createFilmSource(service: FilmService): FilmDataSource {
        return FilmDataSourceImp(service = service)
    }

    @Provides
    @Singleton
    fun getFilmRepository(remoteDataSource: FilmDataSource): FilmRepository {
        return FilmRepositoryImp(remoteDataSource = remoteDataSource)
    }


}