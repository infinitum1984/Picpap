package com.empty.picpap.data.net

import com.empty.picpap.data.net.model.PhotoCloud
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos/random/?client_id=3WIvJQnUh4AomoGS0wBgvdlHmSX2XhK-c3bVdJer_po&orientation=portrait")
    suspend fun getRandomPhoto(): Response<PhotoCloud>

}