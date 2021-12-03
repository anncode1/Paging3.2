package com.anncode.paging32.presentation

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.anncode.paging32.data.model.Pokemon
import com.anncode.paging32.data.repository.PokemonRepository
import com.anncode.paging32.utils.Result
import javax.inject.Inject

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
class MainActivityViewModel @Inject constructor(
    pokemonRepository: PokemonRepository
) : ViewModel() {

    /*val result: MutableLiveData<Result<List<Pokemon>>> = MutableLiveData(Result.Loading)
    val pokemons = Transformations.switchMap(result) {
        val po = pokemonRepository.getPokemons().cachedIn(viewModelScope)
        result.postValue(po.value)
        po
    }*/

    val lala = MutableLiveData("")
    val pokemons = lala.switchMap {
        pokemonRepository.getPokemons().cachedIn(viewModelScope)
    }

    class Factory(
        private val pokemonRepository: PokemonRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            MainActivityViewModel(pokemonRepository) as T
    }
}
