package com.gemidroid.news.data.repository

import com.gemidroid.news.data.entities.NewsResult
import io.reactivex.rxjava3.core.Single

interface IGetArticlesRepository {

    fun getArticlesByCountry(countryCode: String): Single<NewsResult>
}
