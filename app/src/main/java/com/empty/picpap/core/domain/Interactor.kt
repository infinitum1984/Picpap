package com.empty.picpap.core.domain

interface Interactor<I, O> {
    fun invoke(input: I): O
}

interface InteractorNoParams<O> {
    fun invoke(): O
}

interface InteractorAsync<I, O> {
    suspend fun invoke(input: I): O
}

interface InteractorAsyncNoParams<O> {
    suspend fun invoke(): O
}
