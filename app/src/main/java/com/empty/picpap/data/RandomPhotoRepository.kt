package com.empty.picpap.data

import com.empty.picpap.data.model.RandomPhotoData

interface RandomPhotoRepository {

    suspend fun getRandomPhoto(): RandomPhotoData

    suspend fun changeCurrentPhotoFavoriteStatus()

    fun saveCurrentPhoto()

    fun makeCurrentPhotoWallpaper()

}