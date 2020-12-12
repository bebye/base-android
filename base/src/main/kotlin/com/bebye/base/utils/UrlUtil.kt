package com.bebye.base.utils

/**
 * Created by mkwon on 08/12/2020.
 */
object UrlUtil {

    fun isUrl(url: String) = url.startsWith("http://") || url.startsWith("https://")

    fun isGif(url: String?) = url?.matches(Regex(".*.gif$", RegexOption.IGNORE_CASE)) ?: false

}