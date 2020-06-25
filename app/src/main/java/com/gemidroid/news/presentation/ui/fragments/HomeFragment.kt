package com.gemidroid.news.presentation.ui.fragments;

import com.gemidroid.news.base.BaseFragment
import com.gemidroid.news.data.entities.Articles

class HomeFragment : BaseFragment() {

    override fun representListItems(allNews: List<Articles>): List<Articles> {
        val homeNews = mutableListOf<Articles>()
        allNews.apply {
            homeNews.add(get(0))
            homeNews.add(get(3))
            homeNews.add(get(6))
        }
        return homeNews
    }

}
