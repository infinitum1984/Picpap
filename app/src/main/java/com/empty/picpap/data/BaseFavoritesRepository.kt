package com.empty.picpap.data

import com.empty.picpap.core.data.DataResult
import com.empty.picpap.core.data.ErrorType
import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.data.cache.CacheDataSource
import com.empty.picpap.data.mapper.CachePhotoToDataPhotoMapper
import com.empty.picpap.data.model.PhotoData

class BaseFavoritesRepository(private val cacheDataSource: CacheDataSource,
                              private val mapper: CachePhotoToDataPhotoMapper
): FavoritePhotoRepository {
    override suspend fun getFavoritePhotos(): DataResult<List<PhotoData>> {
        val favoritePhotos = cacheDataSource.getFavoritePhotos()
        if (favoritePhotos.isEmpty()){
            return DataResult.Error(ErrorType.EMPTY_LIST)
        }else{
            return DataResult.Success(favoritePhotos.map { mapper.map(it) })
        }
    }

    override fun removePhoto(id: Int) {
        cacheDataSource.removePhotoById(id)
    }
}