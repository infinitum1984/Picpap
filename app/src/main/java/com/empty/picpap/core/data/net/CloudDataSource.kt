package com.empty.picpap.core.data.net

import com.empty.picpap.data.net.model.PhotoCloud

interface CloudDataSource {

    suspend fun getRandomPhoto(): CloudResult<PhotoCloud>

}

