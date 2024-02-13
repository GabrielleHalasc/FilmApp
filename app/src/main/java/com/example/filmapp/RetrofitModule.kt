package com.example.filmapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.remote.film.FilmService
import data.response.ParamsInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val timeout = 15L

    @Provides
    fun provideParamsInt(): ParamsInterceptor {
        return ParamsInterceptor()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        }
    }

    @Provides
    fun provideOkHttpClient(
        paramsInterceptor: ParamsInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(paramsInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(timeout,TimeUnit.SECONDS)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    fun provideGsonFactory(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun proviteFilmService(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): FilmService{
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
            .create(FilmService::class.java)
    }
}