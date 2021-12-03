package com.anncode.paging32.data.network

import com.anncode.paging32.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by anahi.salgado on 01-Dec-21.
 */
interface PokemonApiService {

    // https://pokeapi.co/api/v2/pokemon?limit=10&offset=0
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") page: Int,
        @Query("limit") size: Int
    ): PokemonResponse

}
