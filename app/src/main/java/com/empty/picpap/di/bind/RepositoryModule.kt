package com.empty.picpap.di.bind

import com.empty.picpap.core.data.FavoritePhotoRepository
import com.empty.picpap.core.data.RandomPhotoRepository
import com.empty.picpap.data.BaseFavoritesRepository
import com.empty.picpap.data.BaseRandomPhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindFavoritePhotoRepository(baseCacheDatasource: BaseFavoritesRepository): FavoritePhotoRepository

    @Binds
    abstract fun bindRandomPhotoRepository(cloudDataSource: BaseRandomPhotoRepository): RandomPhotoRepository
}