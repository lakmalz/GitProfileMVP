package com.lakmalz.gitprofilemvp.util

sealed class AppResult<out T> {
    data class Success<out T>(val data: T) : AppResult<T>()
    data class Error(val exception: DataSourceException) : AppResult<Nothing>()
    object Loading : AppResult<Nothing>()
}

inline fun <T : Any> AppResult<T>.onSuccess(action: (T) -> Unit): AppResult<T> {
    if (this is AppResult.Success) action(data)
    return this
}

inline fun <T : Any> AppResult<T>.onError(action: (DataSourceException) -> Unit): AppResult<T> {
    if (this is AppResult.Error) action(exception)
    return this
}

inline fun <T : Any> AppResult<T>.onLoading(action: () -> Unit): AppResult<T> {
    if (this is AppResult.Loading) action()
    return this
}