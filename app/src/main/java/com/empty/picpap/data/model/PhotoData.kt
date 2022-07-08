package com.empty.picpap.data.model

data class PhotoData(
    val id: Int,
    val unsplashId: String,
    val rawUrl: String,
    val fullUrl: String,
    val isFavorite: Boolean
)
