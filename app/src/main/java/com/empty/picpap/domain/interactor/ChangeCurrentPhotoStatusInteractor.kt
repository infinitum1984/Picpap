package com.empty.picpap.domain.interactor

import com.empty.picpap.R
import com.empty.picpap.core.data.DataResult
import com.empty.picpap.core.data.RandomPhotoRepository
import com.empty.picpap.core.domain.DomainResult
import com.empty.picpap.core.domain.InteractorAsyncNoParams
import com.empty.picpap.core.domain.InteractorNoParams
import com.empty.picpap.domain.mapper.PhotoDataToRandomPhotoDomain
import com.empty.picpap.domain.model.RandomPhotoDomain
import javax.inject.Inject

class ChangeCurrentPhotoStatusInteractor @Inject constructor(
    private val randomPhotoRepository: RandomPhotoRepository,
    private val mapper: PhotoDataToRandomPhotoDomain
) : InteractorAsyncNoParams<DomainResult<RandomPhotoDomain>> {
    override suspend fun invoke(): DomainResult<RandomPhotoDomain> {
        val randomPhoto = randomPhotoRepository.changeCurrentPhotoFavoriteStatus()
        val domainData = when(randomPhoto){
            is DataResult.Success -> DomainResult.Success(mapper.map(randomPhoto.data))
            is DataResult.Error -> DomainResult.Error(R.string.error)
        }
        return domainData
    }
}