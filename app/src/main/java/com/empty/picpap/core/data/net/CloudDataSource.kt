package com.empty.picpap.core.data.net

import com.empty.picpap.data.net.model.PhotoCloud

interface CloudDataSource {

    fun getRandomPhoto(): CloudResult<PhotoCloud>

}

