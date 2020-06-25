package com.gemidroid.news.domain

import androidx.lifecycle.MutableLiveData
import com.gemidroid.news.base.IExecutors
import com.gemidroid.news.base.TOTAL_NEWS
import com.gemidroid.news.base.UseCase
import com.gemidroid.news.data.entities.Articles
import com.gemidroid.news.data.repository.IGetArticlesRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class GetArticlesUseCase(
    private val executors: IExecutors,
    private val compositeDisposable: CompositeDisposable,
    private val repository: IGetArticlesRepository)
                               : UseCase<String, Unit> {


    override fun execute(param: String) {
        compositeDisposable.add(
            repository.getArticlesByCountry(countryCode = param)
                .map {
                    it.copy(getAllArticles = it.getAllArticles.subList(0,3))
                }
                .doFinally {
                    isLoading.postValue(false)
                }
                .observeOn(executors.getMainThread())
                .subscribeOn(executors.getIOThread())
                .subscribe(
                    { newsResult ->
                        addedList.addAll(newsResult.getAllArticles)
                        // Only populate when get all three news from 3 different countries.
                        if(addedList.size == TOTAL_NEWS)
                         getAllArticles.value = addedList }
                    , { Exceptions -> getExceptions.value = Exceptions }
                )
        )
    }

    private val addedList= mutableListOf<Articles>()
    var isLoading = MutableLiveData<Boolean>()
    val getAllArticles = MutableLiveData<List<Articles>>()
    val getExceptions = MutableLiveData<Throwable>()

}
