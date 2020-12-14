package com.bebye.base

import com.bebye.base.utils.DateUtil
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

/**
 * Created by mkwon on 13/12/2020.
 */
class DateUtilTest {

    @Test
    fun testGetDate() {
        assertThat(DateUtil.getDate("1/12/2021", "M/d/yyyy"))
            .isInstanceOf(Date::class.java)
    }

    @Test
    fun testGetDateTimeFormat() {
        val date = DateUtil.getDateTimeFormat("1/12/2021", "M/d/yyyy", "MM/dd/yyyy")
        assertThat(date).containsMatch("01/12/2021")
    }

    @Test
    fun testGetDateTimeFormatBasedLocale() {
        var date = DateUtil.getDateTimeFormatBasedLocale("1/12/2021", "M/d/yyyy", Locale.KOREA)
        assertThat(date).containsMatch("2021. 1. 12")

        date = DateUtil.getDateTimeFormatBasedLocale("1/12/2021", "M/d/yyyy", Locale.US)
        assertThat(date).containsMatch("Jan 12, 2021")

        date = DateUtil.getDateTimeFormatBasedLocale("1/12/2021", "M/d/yyyy", Locale.CHINA)
        assertThat(date).containsMatch("2021-1-12")

        date = DateUtil.getDateTimeFormatBasedLocale("1/12/2021", "M/d/yyyy", Locale.FRANCE)
        assertThat(date).containsMatch("12 janv. 2021")
    }

}