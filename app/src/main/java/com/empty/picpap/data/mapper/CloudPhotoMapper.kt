package com.empty.picpap.data.mapper

import com.empty.picpap.core.domain.Mapper
import com.empty.picpap.data.model.PhotoData
import com.empty.picpap.data.net.model.PhotoCloud
import javax.inject.Inject

class CloudPhotoMapper @Inject constructor() : Mapper<PhotoCloud, PhotoData> {
    override fun map(input: PhotoCloud) = PhotoData(
        id = -1,
        unsplashId = input.id,
        rawUrl = input.urls.raw ?: "",
        fullUrl = input.urls.full ?: "",
        isFavorite = false
    )
}