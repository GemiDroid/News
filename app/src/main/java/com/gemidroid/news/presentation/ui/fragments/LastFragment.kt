package com.gemidroid.news.presentation.ui.fragments

import com.gemidroid.news.base.BaseFragment
import com.gemidroid.news.data.entities.Articles

class LastFragment : BaseFragment() {

    override fun representListItems(allNews: List<Articles>): List<Articles> {
        val thirdNews = mutableListOf<Articles>()
        allNews.apply {
            thirdNews.add(get(2))
            thirdNews.add(get(5))
            thirdNews.add(get(8))
        }
        return thirdNews
    }
}