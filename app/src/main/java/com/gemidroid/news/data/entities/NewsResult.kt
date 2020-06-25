package com.gemidroid.news.data.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsResult (@SerializedName("articles") var  getAllArticles : List<Articles>)
    : Serializable