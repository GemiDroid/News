package com.gemidroid.news.data.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Articles (
    @SerializedName("author") var author: String?,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("urlToImage") var imgUrl: String,
    @SerializedName("publishedAt") var publishDate: String) : Serializable

