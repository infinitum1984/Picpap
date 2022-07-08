package com.empty.picpap.core.data

sealed class DataResult<out T> {
    class Success<out S>(val data: S): DataResult<S> ()
    class Error(val error: ErrorType): DataResult<Nothing> ()
}

enum class ErrorType {
    NO_CONNECTION,
    EMPTY_LIST,
    NO_CURRENT_PHOTO
}
