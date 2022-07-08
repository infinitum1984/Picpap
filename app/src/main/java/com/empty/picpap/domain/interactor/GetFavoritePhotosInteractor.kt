package com.empty.picpap.domain.interactor

import com.empty.picpap.core.data.DataResult
import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.domain.DomainResult
import com.empty.picpap.core.domain.InteractorAsyncNoParams
import com.empty.picpap.domain.mapper.PhotoDataToPhotoItemDomain
import com.empty.picpap.domain.model.PhotoItemDomain

class GetFavoritePhotosInteractor(
    private val favoritesRepository: FavoritePhotoRepository,
    private val photoDataToPhotoItemDomain: PhotoDataToPhotoItemDomain
) : InteractorAsyncNoParams<DomainResult<List<PhotoItemDomain>>> {
    override suspend fun invoke(): DomainResult<List<PhotoItemDomain>> {
        val favoritesData = favoritesRepository.getFavoritePhotos()
        val domainResult = when (favoritesData) {
            is DataResult.Error -> DomainResult.Error("")
            is DataResult.Success -> DomainResult.Success(
                favoritesData.data.map { photoDataToPhotoItemDomain.map(it) })
        }
        return domainResult
    }
}