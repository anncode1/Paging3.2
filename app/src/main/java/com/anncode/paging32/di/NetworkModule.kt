package com.anncode.paging32.di

import com.anncode.paging32.data.network.PokemonApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by anahi.salgado on 01-Dec-21.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesAirlinesApi(): PokemonApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApiService::class.java)

    }

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}






