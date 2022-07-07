package com.empty.picpap.data.net

import com.empty.picpap.data.net.model.PhotoCloud

interface ApiService {

    fun getRandomPhoto(): PhotoCloud

}