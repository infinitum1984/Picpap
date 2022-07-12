package com.empty.picpap.data.net

import android.util.Log
import com.empty.picpap.core.data.net.CloudDataSource
import com.empty.picpap.core.data.net.CloudResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseCloudDataSource @Inject constructor(private val apiService: ApiService) : CloudDataSource {

    override suspend fun getRandomPhoto() =
        try {
            val randomPhoto = apiService.getRandomPhoto()
            CloudResult.Success(randomPhoto.body()!!)
        } catch (e: Exception) {
            Log.e("BaseCloudDataSource", e.toString())
            CloudResult.Error(e)
        }

}