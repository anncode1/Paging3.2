package com.anncode.paging32.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.anncode.paging32.data.model.Pokemon
import com.anncode.paging32.data.network.PokemonApiService
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
private const val FIRST_PAGE = 0
class PokemonPagingSource(
    private val pokemonApiService: PokemonApiService
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val page = params.key ?: FIRST_PAGE
        val size = params.loadSize
        val previousPage = if (page == FIRST_PAGE) null else page - size

        return try {
            val pokemonResponse = pokemonApiService.getPokemons(page, size)
            val nextPage = if (pokemonResponse.pokemons.isEmpty()) {
                null
            } else page + size
            LoadResult.Page(
                pokemonResponse.pokemons,
                previousPage,
                nextPage
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }



    
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? = null

}
