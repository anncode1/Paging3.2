package com.anncode.paging32.data.model

import com.anncode.paging32.utils.NetworkConstants.Companion.COUNT
import com.anncode.paging32.utils.NetworkConstants.Companion.NEXT
import com.anncode.paging32.utils.NetworkConstants.Companion.PREVIOUS
import com.anncode.paging32.utils.NetworkConstants.Companion.RESULTS
import com.google.gson.annotations.SerializedName

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
data class PokemonResponse(
    @SerializedName(COUNT) val dataSize: Int,
    @SerializedName(NEXT) val nextUrl: String,
    @SerializedName(PREVIOUS) val previousUrl: String,
    @SerializedName(RESULTS) val pokemons: List<Pokemon>
)
