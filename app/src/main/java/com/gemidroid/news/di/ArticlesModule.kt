package com.gemidroid.news.di

import com.gemidroid.news.base.*
import com.gemidroid.news.domain.GetArticlesUseCase
import com.gemidroid.news.data.repository.GetArticlesRepository
import com.gemidroid.news.data.repository.IGetArticlesRepository
import com.gemidroid.news.data.webApi.NewsApi
import com.gemidroid.news.presentation.ui.viewmodel.GetNewsViewModel
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val articlesModule= module {

    single<OkHttpClient> {
        val builder = OkHttpClient.Builder()
        builder
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        builder.build()
    }

    single { GsonBuilder().serializeNulls().create() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
       .addConverterFactory(GsonConverterFactory.create(get()))
      .client(get<OkHttpClient>())
            .build()
    }

    factory { get<Retrofit>().create(NewsApi::class.java) }

    factory<IGetArticlesRepository> { GetArticlesRepository(get()) }

    factory<IExecutors> { Executors() }

    factory { CompositeDisposable() }

    factory { GetArticlesUseCase(get(),get(),get()) }

    viewModel { GetNewsViewModel(get()) }
}