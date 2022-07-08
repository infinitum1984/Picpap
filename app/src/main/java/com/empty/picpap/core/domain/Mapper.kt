package com.empty.picpap.core.domain

interface Mapper<I,O> {
    fun map(input: I): O
}