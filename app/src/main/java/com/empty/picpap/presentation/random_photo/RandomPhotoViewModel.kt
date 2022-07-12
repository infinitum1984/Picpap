package com.empty.picpap.presentation.random_photo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.empty.picpap.core.domain.DomainResult
import com.empty.picpap.domain.interactor.ChangeCurrentPhotoStatusInteractor
import com.empty.picpap.domain.interactor.GetRandomPhotoInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomPhotoViewModel @Inject constructor(
    private val getRandomPhoto: GetRandomPhotoInteractor,
    private val changeCurrentPhotoStatus: ChangeCurrentPhotoStatusInteractor
) : ViewModel() {

    private val _photoImg = MutableLiveData<String>()
    val photoImg: LiveData<String> = _photoImg

    init {
        getRandomPhoto()
    }

    fun getRandomPhoto() {
        viewModelScope.launch {
            val result = getRandomPhoto.invoke()
            Log.d("ViewModel", result.toString())
            if (result is DomainResult.Success){
                _photoImg.value = result.data.fullUrl
            }
        }
    }

}