package com.empty.picpap.di

import android.content.Context
import com.empty.picpap.data.cache.PicpapeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideLogDao(database: PicpapeDatabase) = database.photoDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        PicpapeDatabase.create(appContext)

}