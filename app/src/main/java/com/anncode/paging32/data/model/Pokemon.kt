package com.anncode.paging32.data.model

import com.anncode.paging32.utils.NetworkConstants.Companion.NAME
import com.anncode.paging32.utils.NetworkConstants.Companion.URL
import com.google.gson.annotations.SerializedName

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
data class Pokemon(
    @SerializedName(NAME) val name: String,
    @SerializedName(URL) val url: String
)
