package com.empty.picpap.core.data

import com.empty.picpap.data.model.PhotoData

interface RandomPhotoRepository {

    suspend fun getRandomPhoto(): DataResult<PhotoData>

    suspend fun changeCurrentPhotoFavoriteStatus(): DataResult<PhotoData>

    fun saveCurrentPhoto()

    fun makeCurrentPhotoWallpaper()

}

