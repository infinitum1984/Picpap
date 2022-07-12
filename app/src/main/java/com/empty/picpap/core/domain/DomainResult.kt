package com.empty.picpap.core.domain

import androidx.annotation.StringRes

sealed class DomainResult<out T> {
    class Success<out S>(val data: S): DomainResult<S> ()
    class Error(@StringRes val errorId: Int): DomainResult<Nothing> ()
}

