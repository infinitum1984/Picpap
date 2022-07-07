package com.empty.picpap.core.data

sealed class DataResult<out T> {
    class Success<out S>(data: S): DataResult<S> ()
    class Error(error: ErrorType): DataResult<Nothing> ()
}

class ErrorType {

}
