package com.anncode.paging32.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.anncode.paging32.data.model.Pokemon
import com.anncode.paging32.data.network.PokemonApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonApiService
) {

    fun getPokemons(): Flow<PagingData<Pokemon>> =
        Pager(
            config = PagingConfig(
                pageSize = 20, // loadSize
                initialLoadSize = 30,
                enablePlaceholders = false,
                prefetchDistance = 5
            ),
            pagingSourceFactory = { PokemonPagingSource(pokemonApiService) }
        ).flow

}
