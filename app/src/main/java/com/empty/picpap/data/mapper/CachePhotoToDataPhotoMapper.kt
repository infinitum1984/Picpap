package com.empty.picpap.data.mapper

import com.empty.picpap.core.domain.Mapper
import com.empty.picpap.data.cache.CachePhoto
import com.empty.picpap.data.model.PhotoData
import javax.inject.Inject

class CachePhotoToDataPhotoMapper @Inject constructor(): Mapper<CachePhoto, PhotoData> {
    override fun map(input: CachePhoto) = PhotoData(
        id = input.id,
        unsplashId = input.unsplashId,
        rawUrl = input.rawUrl,
        fullUrl = input.fullUrl,
        isFavorite = input.isFavorite
    )
}
