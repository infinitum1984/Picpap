package com.empty.picpap.data.net

import com.empty.picpap.data.net.model.PhotoCloud

interface CloudDataSource {

    fun getRandomPhoto(): PhotoCloud

}