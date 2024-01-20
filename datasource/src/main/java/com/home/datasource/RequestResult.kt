package com.home.datasource

/**
 * Class that holds the request result made by
 * retrofit library
 * @author Yago H Pereira <yago.henriquep@gmail.com>
 * @since 20/01/2024
 * @version 1.0.0
 */
sealed class RequestResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : RequestResult<T>()
    data class Error(val exception: Exception) : RequestResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}