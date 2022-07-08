package com.empty.picpap.presentation.favorites

import androidx.lifecycle.ViewModel
import com.empty.picpap.domain.interactor.GetFavoritePhotosInteractor
import com.empty.picpap.domain.interactor.RemovePhotoByIdIteractor

class FavoritesViewModel(private val getFavoritePhotos: GetFavoritePhotosInteractor,
                         private val removePhotoById: RemovePhotoByIdIteractor
                         ): ViewModel() {
}