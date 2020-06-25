package com.gemidroid.news.data.webApi

import com.gemidroid.news.data.entities.NewsResult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getArticles (@Query("country") countryCode: String ,
                     @Query("apiKey") apiKey: String )
            : Single<NewsResult>
}