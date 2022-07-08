package com.empty.picpap.core.data.net

import kotlin.Exception

sealed class CloudResult<out T> {
    class Success<out S>(val data: S): CloudResult<S> ()
    class Error(val error: Exception): CloudResult<Nothing> ()
}