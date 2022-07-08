package com.empty.picpap.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao{
    @Query("SELECT * FROM CachePhoto WHERE isFavorite = 1")
    fun getFavoritePhotos(): List<CachePhoto>

    @Query("DELETE FROM CachePhoto WHERE id = :id")
    fun deletePhotoById(id: Int)

    @Insert
    fun addPhoto(cachePhoto: CachePhoto): Int
}