package com.empty.picpap.domain.mapper

import com.empty.picpap.core.domain.Mapper
import com.empty.picpap.data.model.PhotoData
import com.empty.picpap.domain.model.RandomPhotoDomain

class PhotoDataToRandomPhotoDomain: Mapper<PhotoData,RandomPhotoDomain> {
    override fun map(input: PhotoData) = RandomPhotoDomain(
        input.rawUrl,
        input.fullUrl,
        input.isFavorite
    )
}