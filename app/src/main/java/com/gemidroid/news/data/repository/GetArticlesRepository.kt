package com.gemidroid.news.data.repository

import com.gemidroid.news.base.API_KEY
import com.gemidroid.news.data.entities.NewsResult
import com.gemidroid.news.data.webApi.NewsApi
import io.reactivex.rxjava3.core.Single

class GetArticlesRepository (var newsApi: NewsApi ): IGetArticlesRepository  {
    override fun getArticlesByCountry(countryCode: String) : Single<NewsResult> =
        newsApi.getArticles(countryCode, API_KEY)
}