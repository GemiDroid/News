package com.gemidroid.news.base;

 interface UseCase<S, T> {
   fun execute(param : S): T
}
