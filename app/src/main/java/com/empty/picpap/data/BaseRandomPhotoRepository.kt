package com.empty.picpap.data

import android.util.Log
import com.empty.picpap.core.data.DataResult
import com.empty.picpap.core.data.ErrorType
import com.empty.picpap.core.data.RandomPhotoRepository
import com.empty.picpap.core.data.cache.CacheDataSource
import com.empty.picpap.core.data.net.CloudResult
import com.empty.picpap.data.mapper.CloudPhotoMapper
import com.empty.picpap.data.model.PhotoData
import com.empty.picpap.core.data.net.CloudDataSource
import com.empty.picpap.data.mapper.PhotoDataToCachePhotoMapper
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseRandomPhotoRepository @Inject constructor(
    private val cloudDataSource: CloudDataSource,
    private val cloudPhotoMapper: CloudPhotoMapper,
    private val cacheDataSource: CacheDataSource
) : RandomPhotoRepository {

    private var currentPhoto: PhotoData? = null

    override suspend fun getRandomPhoto(): DataResult<PhotoData> {
        val randomPhoto = cloudDataSource.getRandomPhoto()

        return when (randomPhoto) {
            is CloudResult.Error -> {
                Log.d("ViewModel", randomPhoto.error.message?:"error")

                DataResult.Error(ErrorType.NO_CONNECTION)
            }
            is CloudResult.Success -> {
                val photo = cloudPhotoMapper.map(randomPhoto.data)
                currentPhoto = photo
                DataResult.Success(photo)
            }
        }
    }

    override suspend fun changeCurrentPhotoFavoriteStatus(): DataResult<PhotoData> {
        if (currentPhoto == null) return DataResult.Error(ErrorType.NO_CURRENT_PHOTO)
        val currentPhoto = currentPhoto!!
        if (currentPhoto.isFavorite) {
            cacheDataSource.removePhotoById(currentPhoto.id)
            return DataResult.Success(currentPhoto.copy(id = -1, isFavorite = false))
        } else {
            val id = cacheDataSource.addPhoto(currentPhoto)
            return DataResult.Success(currentPhoto.copy(id = id, isFavorite = true))
        }
    }

    override fun saveCurrentPhoto() {
        TODO("Not yet implemented")
    }

    override fun makeCurrentPhotoWallpaper() {
        TODO("Not yet implemented")
    }

}