package com.anncode.paging32.di

import com.anncode.paging32.data.repository.PokemonRepository
import com.anncode.paging32.presentation.MainActivityViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
@Module
class ViewModelModule {

    @Provides
    fun providesMainViewModelFactory(
        pokemonRepository: PokemonRepository
    ) = MainActivityViewModel.Factory(pokemonRepository)
}
