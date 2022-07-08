package com.empty.picpap.domain.interactor

import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.domain.InteractorAsync

class RemovePhotoByIdIteractor(private val favoritePhotoRepository: FavoritePhotoRepository):
    InteractorAsync<Int,Unit> {
    override suspend fun invoke(id: Int) =
        favoritePhotoRepository.removePhoto(id)
}