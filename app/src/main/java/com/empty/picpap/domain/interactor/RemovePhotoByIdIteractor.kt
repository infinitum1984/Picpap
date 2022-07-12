package com.empty.picpap.domain.interactor

import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.domain.InteractorAsync
import javax.inject.Inject

class RemovePhotoByIdIteractor @Inject constructor(private val favoritePhotoRepository: FavoritePhotoRepository) :
    InteractorAsync<Long, Unit> {
    override suspend fun invoke(id: Long) =
        favoritePhotoRepository.removePhoto(id)
}