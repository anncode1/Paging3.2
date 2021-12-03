package com.anncode.paging32.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.anncode.paging32.data.model.Pokemon
import com.anncode.paging32.data.network.PokemonApiService
import javax.inject.Inject

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonApiService
) {

    fun getPokemons(): LiveData<PagingData<Pokemon>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PokemonPagingSource(pokemonApiService) }
        ).liveData

}
