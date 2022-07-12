package com.empty.picpap.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CachePhoto::class], version = 1)
abstract class PicpapeDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {
        fun create(context: Context) = Room.databaseBuilder(
            context,
            PicpapeDatabase::class.java,
            "picpape-database"
        ).build()
    }
}
