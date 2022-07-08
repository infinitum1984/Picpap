package com.empty.picpap.data.mapper

import com.empty.picpap.core.domain.Mapper
import com.empty.picpap.data.cache.CachePhoto
import com.empty.picpap.data.model.PhotoData
import javax.inject.Inject

class PhotoDataToCachePhotoMapper @Inject constructor() : Mapper<PhotoData, CachePhoto> {
    override fun map(input: PhotoData) = CachePhoto(
        id = input.id,
        unsplashId = input.unsplashId,
        rawUrl = input.rawUrl,
        fullUrl = input.fullUrl,
        isFavorite = input.isFavorite
    )
}