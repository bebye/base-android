package com.bebye.base.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by mkwon on 13/12/2020.
 */
object DateUtil {

    fun getDateTimeFormat(dateTime: String, sourceDateTimeFormat: String, resultDateTimeFormat: String): String? {
        return getDate(dateTime, sourceDateTimeFormat)?.let {
            SimpleDateFormat(resultDateTimeFormat, Locale.getDefault()).format(it)
        }
    }

    fun getDateTimeFormatBasedLocale(
        dateTime: String,
        sourceDateTimeFormat: String,
        locale: Locale = Locale.getDefault(),
        style: Int = DateFormat.MEDIUM
    ): String? {
        return getDate(dateTime, sourceDateTimeFormat)?.let {
            DateFormat.getDateInstance(style, locale).format(it)
        }
    }

    fun getDate(dateTime: String, dateTimeFormat: String): Date? {
        return SimpleDateFormat(dateTimeFormat, Locale.getDefault()).parse(dateTime)
    }

}