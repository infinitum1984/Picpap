package com.empty.picpap.data.cache

import com.empty.picpap.core.data.cache.CacheDataSource
import com.empty.picpap.data.mapper.PhotoDataToCachePhotoMapper
import com.empty.picpap.data.model.PhotoData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseCacheDatasource @Inject constructor(
    private val photoDao: PhotoDao,
    private val mapper: PhotoDataToCachePhotoMapper
) : CacheDataSource {
    override fun getFavoritePhotos() = photoDao.getFavoritePhotos()

    override fun removePhotoById(id: Long) = photoDao.deletePhotoById(id)

    override fun addPhoto(photoData: PhotoData) = photoDao.addPhoto(mapper.map(photoData))
}