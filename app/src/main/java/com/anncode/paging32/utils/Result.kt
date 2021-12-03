package com.anncode.paging32.utils

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
sealed class Result<out T: Any> {
    object Loading: Result<Nothing>()
    data class Success<out T : Any>(val data: T): Result<T>()
    data class Error(val errorMessage: Throwable): Result<Nothing>()
}
