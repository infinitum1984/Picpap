package com.empty.picpap.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CachePhoto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val unsplashId: String,
    val rawUrl: String,
    val fullUrl: String,
    val isFavorite: Boolean
)
