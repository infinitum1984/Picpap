package com.empty.picpap.data

import com.empty.picpap.core.data.DataResult
import com.empty.picpap.core.data.ErrorType
import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.data.cache.CacheDataSource
import com.empty.picpap.data.mapper.CachePhotoToDataPhotoMapper
import com.empty.picpap.data.model.PhotoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseFavoritesRepository @Inject constructor(private val cacheDataSource: CacheDataSource,
                              private val mapper: CachePhotoToDataPhotoMapper
): FavoritePhotoRepository {
    override suspend fun getFavoritePhotos(): DataResult<List<PhotoData>> = withContext(Dispatchers.IO) {
        val favoritePhotos = cacheDataSource.getFavoritePhotos()
        if (favoritePhotos.isEmpty()){
            return@withContext DataResult.Error(ErrorType.EMPTY_LIST)
        }else{
            return@withContext DataResult.Success(favoritePhotos.map { mapper.map(it) })
        }
    }

    override fun removePhoto(id: Long) {
        cacheDataSource.removePhotoById(id)
    }
}