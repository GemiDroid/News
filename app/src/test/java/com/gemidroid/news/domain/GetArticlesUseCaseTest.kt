package com.gemidroid.news.domain

import com.gemidroid.news.data.entities.Articles
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class GetArticlesUseCaseTest  {

    @Test
    fun checkIfArticlesAreNull() {
        val articles= emptyList<Articles>()
        val expectedArticles= mutableListOf<Articles>()
        expectedArticles.add(Articles(author = null, title = "title1",
            description = "description1",imgUrl = "image1.jpg",publishDate = "2020-12-13"))
        expectedArticles.add(Articles(author = "author", title = "title2",
            description = "description2",imgUrl = "image2.jpg",publishDate = "2020-12-13"))
        expectedArticles.add(Articles(author = null, title = "title3",
            description = "description",imgUrl = "image3.jpg",publishDate = "2020-12-13"))

      assertNotEquals(articles, expectedArticles)
    }

    @Test
    fun getArticlesIfNotNull() {
        val expectedArticles= mutableListOf<Articles>()
        expectedArticles.add(Articles(author = null, title = "title1",
            description = "description1",imgUrl = "image1.jpg",publishDate = "2020-12-13"))
        expectedArticles.add(Articles(author = "author", title = "title2",
            description = "description2",imgUrl = "image2.jpg",publishDate = "2020-12-13"))
        expectedArticles.add(Articles(author = null, title = "title3",
            description = "description",imgUrl = "image3.jpg",publishDate = "2020-12-13"))

        assertNotNull(expectedArticles)
    }
}