package com.anncode.paging32.di

import com.anncode.paging32.data.network.PokemonApiService
import com.anncode.paging32.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
@Module
class RepositoryModule {

    @Provides
    fun providesPokemonRepository(
        pokemonApiService: PokemonApiService
    ) = PokemonRepository(pokemonApiService)
}
