package com.empty.picpap.di.bind

import com.empty.picpap.core.data.cache.CacheDataSource
import com.empty.picpap.core.data.net.CloudDataSource
import com.empty.picpap.data.cache.BaseCacheDatasource
import com.empty.picpap.data.net.BaseCloudDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindCacheDataSource(baseCacheDatasource: BaseCacheDatasource): CacheDataSource

    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: BaseCloudDataSource): CloudDataSource
}