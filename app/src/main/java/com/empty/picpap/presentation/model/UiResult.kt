package com.empty.picpap.presentation.model

sealed class UiResult<out T> {
    class Success<out S>(val data: S): UiResult<S> ()
    class Error(val message: String): UiResult<Nothing> ()
}