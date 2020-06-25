package com.gemidroid.news.base

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.gemidroid.news.di.articlesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

 class BaseApplication : Application() {

    override fun  onCreate() {
        super.onCreate()
        start(this)
        Fresco.initialize(this)
    }

     private fun start(application: Application) {
         startKoin {
             androidContext(application)
             modules(articlesModule)
         }
     }
 }
