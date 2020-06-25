package com.gemidroid.news.presentation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gemidroid.news.base.EGYPT_CODE
import com.gemidroid.news.base.EMIRATES_CODE
import com.gemidroid.news.base.SAUDI_ARABIA_CODE
import com.gemidroid.news.domain.GetArticlesUseCase
import com.gemidroid.news.data.entities.Articles

class GetNewsViewModel(private var getArticlesUseCase: GetArticlesUseCase): ViewModel() {

    init {

        getArticlesUseCase.execute(EGYPT_CODE)

        getArticlesUseCase.execute(SAUDI_ARABIA_CODE)

        getArticlesUseCase.execute(EMIRATES_CODE)
    }

    fun observeOnArticles() : MutableLiveData<List<Articles>> = getArticlesUseCase.getAllArticles

    fun observeOnErrors(): MutableLiveData<Throwable> = getArticlesUseCase.getExceptions

    fun isLoading(): MutableLiveData<Boolean> = getArticlesUseCase.isLoading

}