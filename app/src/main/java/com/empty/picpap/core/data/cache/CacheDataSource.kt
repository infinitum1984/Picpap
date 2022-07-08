package com.empty.picpap.core.data.cache

import com.empty.picpap.data.cache.CachePhoto
import com.empty.picpap.data.model.PhotoData

interface CacheDataSource {

    fun getFavoritePhotos(): List<CachePhoto>

    fun removePhotoById(id: Int)

    fun addPhoto(photoData: PhotoData): Int
}