package com.empty.picpap.core.data

import com.empty.picpap.data.model.PhotoData

interface FavoritePhotoRepository {

    suspend fun getFavoritePhotos(): DataResult<List<PhotoData>>

    fun removePhoto(id: Int)
}