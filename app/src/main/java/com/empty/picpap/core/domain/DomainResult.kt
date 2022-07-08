package com.empty.picpap.core.domain

sealed class DomainResult<out T> {
    class Success<out S>(val data: S): DomainResult<S> ()
    class Error(val error: String): DomainResult<Nothing> ()
}

