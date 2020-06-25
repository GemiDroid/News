package com.gemidroid.news.base;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers


class Executors : IExecutors {
     override fun getIOThread(): io.reactivex.rxjava3.core.Scheduler{
         return io.reactivex.rxjava3.schedulers.Schedulers.io()
     }

     override fun getMainThread(): io.reactivex.rxjava3.core.Scheduler {
         return AndroidSchedulers.mainThread()
     }


 }
