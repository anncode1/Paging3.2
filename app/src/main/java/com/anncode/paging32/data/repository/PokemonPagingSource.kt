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

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val page = params.key ?: FIRST_PAGE
        val size = params.loadSize
        val pageSize = params.loadSize
        val previousPage = if (page == FIRST_PAGE) null else page - 1

        return try {
            val pokemonResponse = pokemonApiService.getPokemons(page, size)
            val nextPage = if (pokemonResponse.pokemons.isEmpty()) {
                null
            } else page + (pageSize / pokemonResponse.dataSize)
            LoadResult.Page(
                pokemonResponse.pokemons,
                previousPage,
                nextPage
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}
