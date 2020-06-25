package com.gemidroid.news.base

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

 @SuppressLint("SimpleDateFormat")
 fun dateFormatter(publishDate: String) : String {
    val fmt = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
    val date = fmt.parse (publishDate)
    val fmtOut =  SimpleDateFormat("EEEE dd-MM-yyyy hh:mm a", Locale("ar"))
    return fmtOut.format(date!!)
}