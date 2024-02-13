package data.remote.filmdetail.source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.remote.film.FilmService
import data.remote.filmdetail.repository.FilmDetailRepositoryImp
import data.remote.filmdetail.repository.FilmDetailRepository
import domain.FilmDetailUseCase
import domain.FilmDetailUseCaseImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilmDetailModule {

    @Provides
    @Singleton
    fun provideFilmDetailSource(service: FilmService): FilmDetailDataSource{
        return FilmDetailDataSourceImp(service = service)
    }

    @Provides
    @Singleton
    fun provideFilmDetailRep(dataSource: FilmDetailDataSource): FilmDetailRepository{
        return FilmDetailRepositoryImp(data = dataSource)
    }
    @Provides
    @Singleton
    fun provideFilmDetailUseCase(repository: FilmDetailRepository): FilmDetailUseCase{
        return FilmDetailUseCaseImp(repository = repository)
    }
}