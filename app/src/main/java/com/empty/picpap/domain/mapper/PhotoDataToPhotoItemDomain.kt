package com.empty.picpap.domain.mapper

import com.empty.picpap.core.domain.Mapper
import com.empty.picpap.data.model.PhotoData
import com.empty.picpap.domain.model.PhotoItemDomain

class PhotoDataToPhotoItemDomain: Mapper<PhotoData, PhotoItemDomain> {
    override fun map(input: PhotoData) = PhotoItemDomain(
        id = input.id,
        rawUrl = input.rawUrl,
        fullUrl = input.fullUrl
    )
}