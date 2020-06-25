package com.gemidroid.news.base;

interface IExecutors {

    fun  getIOThread(): io.reactivex.rxjava3.core.Scheduler

    fun getMainThread(): io.reactivex.rxjava3.core.Scheduler
}
