package com.empty.picpap.core.domain

interface Interactor<I, O> {
    fun invoke(input: I): O
}

interface InteractorNoParams<O> : Interactor<Nothing, O> {
    fun invoke(): O
}

interface InteractorAsync<I, O> {
    fun invoke(input: I): O
}

interface InteractorAsyncNoParams<O> : Interactor<Nothing, O> {
    fun invoke(): O
}
