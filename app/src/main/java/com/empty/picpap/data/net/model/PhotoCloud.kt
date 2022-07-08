package com.empty.picpap.data.net.model

import com.google.gson.annotations.SerializedName

data class PhotoCloud(
    @SerializedName("id")
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    @SerializedName("urls")
    val urls: PhotoUrls
)
data class PhotoUrls (
    @SerializedName("raw")
    val raw:String?,
    @SerializedName("full")
    val full:String?,
    @SerializedName("regular")
    val regular:String?,
    @SerializedName("small")
    val small:String?,
    @SerializedName("thumb")
    val thumb:String?
)
