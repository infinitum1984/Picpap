package com.empty.picpap.presentation.random_photo

import androidx.lifecycle.ViewModel
import com.empty.picpap.domain.interactor.ChangeCurrentPhotoStatusInteractor
import com.empty.picpap.domain.interactor.GetRandomPhotoInteractor

class RandomPhotoViewModel(private val getRandomPhoto: GetRandomPhotoInteractor,
                           private val changeCurrentPhotoStatus: ChangeCurrentPhotoStatusInteractor
                           ): ViewModel() {

}