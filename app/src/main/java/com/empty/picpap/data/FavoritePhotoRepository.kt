package com.empty.picpap.data

import com.empty.picpap.data.model.FavoritesData

interface FavoritePhotoRepository {

    suspend fun getFavoritesPhotos(): FavoritesData

    fun removePhoto(id: Int)
}