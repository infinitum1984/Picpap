package com.empty.picpap.domain.interactor

import com.empty.picpap.R
import com.empty.picpap.core.data.DataResult
import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.domain.DomainResult
import com.empty.picpap.core.domain.InteractorAsyncNoParams
import com.empty.picpap.domain.mapper.PhotoDataToPhotoItemDomain
import com.empty.picpap.domain.model.PhotoItemDomain
import javax.inject.Inject

class GetFavoritePhotosInteractor @Inject constructor(
    private val favoritesRepository: FavoritePhotoRepository,
                                                      private val photoDataToPhotoItemDomain: PhotoDataToPhotoItemDomain
) : InteractorAsyncNoParams<DomainResult<List<PhotoItemDomain>>> {
    override suspend fun invoke(): DomainResult<List<PhotoItemDomain>> {
        val favoritesData = favoritesRepository.getFavoritePhotos()
        val domainResult = when (favoritesData) {
            is DataResult.Error -> DomainResult.Error(R.string.error)
            is DataResult.Success -> DomainResult.Success(
                favoritesData.data.map { photoDataToPhotoItemDomain.map(it) })
        }
        return domainResult
    }
}