package com.gemidroid.news.presentation.ui.fragments

import com.gemidroid.news.base.BaseFragment
import com.gemidroid.news.data.entities.Articles

class SecondFragment : BaseFragment() {

    override fun representListItems(allNews: List<Articles>): List<Articles> {
        val secondNews = mutableListOf<Articles>()
        allNews.apply {
            secondNews.add(get(1))
            secondNews.add(get(4))
            secondNews.add(get(7))
        }
        return secondNews
    }


}