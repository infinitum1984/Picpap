package com.empty.picpap

import com.empty.picpap.core.data.cache.CacheDataSource
import com.empty.picpap.core.domain.DomainResult
import com.empty.picpap.data.BaseRandomPhotoRepository
import com.empty.picpap.data.cache.CachePhoto
import com.empty.picpap.data.mapper.CloudPhotoMapper
import com.empty.picpap.data.model.PhotoData
import com.empty.picpap.data.net.ApiService
import com.empty.picpap.data.net.BaseCloudDataSource
import com.empty.picpap.domain.interactor.GetRandomPhotoInteractor
import com.empty.picpap.domain.mapper.PhotoDataToRandomPhotoDomain
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRandomPhotoTest {

    class TestCacheDataSource: CacheDataSource{
        override fun getFavoritePhotos(): List<CachePhoto> {
            TODO("Not yet implemented")
        }

        override fun removePhotoById(id: Long) {
            TODO("Not yet implemented")
        }

        override fun addPhoto(photoData: PhotoData): Long {
            TODO("Not yet implemented")
        }

    }

    @Test
    fun testLoadPhoto() {
        val BASE_URL = "https://api.unsplash.com/"
        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        val cloudDataSource = BaseCloudDataSource(retrofit.create(ApiService::class.java))
        val repository = BaseRandomPhotoRepository(cloudDataSource, CloudPhotoMapper(), TestCacheDataSource())
        val getRandomPhotoInteractor =
            GetRandomPhotoInteractor(repository, PhotoDataToRandomPhotoDomain())
        runBlocking {
            val randomPhoto = getRandomPhotoInteractor.invoke()
            if (randomPhoto is DomainResult.Success){
                println(randomPhoto.data)
            }
            assert(randomPhoto is DomainResult.Success)
        }
    }

}