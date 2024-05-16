package com.mechta.network.utils.result


sealed class NetworkResult<out T>() {

    class Success<T>(val data: T) : NetworkResult<T>()

    sealed class Error<E> : NetworkResult<E>() {
        data class HttpError<E>(
            val code: Int,
            val errorBody: String?,
            val errorMessage: String?,
        ) : Error<E>()

        data class SerializationError(
            val message: String?,
            val errorMessage: String?,
        ) : Error<Nothing>()

        data class GenericError(
            val message: String?,
            val errorMessage: String?,
        ) : Error<Nothing>()
    }
}
