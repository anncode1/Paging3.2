package com.anncode.paging32.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.anncode.paging32.data.repository.PokemonRepository
import javax.inject.Inject

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
class MainActivityViewModel @Inject constructor(
    pokemonRepository: PokemonRepository
) : ViewModel() {

    val pokemons = pokemonRepository.getPokemons().cachedIn(viewModelScope)

    class Factory(
        private val pokemonRepository: PokemonRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            MainActivityViewModel(pokemonRepository) as T
    }
}
