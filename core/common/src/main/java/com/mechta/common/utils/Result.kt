package com.mechta.common.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable) : Result<Nothing>
    data object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return map<T, Result<T>> { data ->
        Result.Success(data)
    }
        .onStart {
            emit(Result.Loading)
        }
        .catch { exception ->
            Log.e("ERROR_APP", exception.message.toString())
            emit(Result.Error(exception))
        }
}

fun <T> Flow<T>.asResultBody(transform: (Result<T>) -> Unit): Flow<Unit> {
    return map { data ->
        transform(Result.Success(data))
    }
        .onStart {
            transform(Result.Loading)
        }
        .catch { exception ->
            Log.e("ERROR_APP", exception.message.toString())
            transform(Result.Error(exception))
        }
}
