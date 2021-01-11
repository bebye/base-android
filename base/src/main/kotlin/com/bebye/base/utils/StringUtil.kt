package com.bebye.base.utils

import android.content.Context
import android.text.*
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.MetricAffectingSpan
import android.view.View
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import java.text.NumberFormat

/**
 * Created by mkwon on 11/01/2021.
 */
class StringUtil {

    val REGEX_URL =
        Regex("[(http(s)?)://(www.)?a-zA-Z0-9@:%._+~#=-]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&//=;]*)")
    val REGEX_NEW_LINE = Regex("[\r|\n]")
    val REGEX_NEW_LINES = Regex("[\r|\n]+")

    fun hasNewLine(text: CharSequence) = text.contains(REGEX_NEW_LINES)

    fun isNewLine(text: CharSequence) = text.matches(REGEX_NEW_LINES)

    fun getEllipsisNumber(number: Long, maxNumber: Int = 999): String {
        var result = number.toString()
        if (number > maxNumber) {
            result = "$maxNumber+"
        }
        return result
    }

    fun getEllipsisText(text: String, maxLength: Int): String {
        val ellipsisText = "…"
        return if (text.length > maxLength) {
            "${text.substring(0, maxLength - ellipsisText.length + 1)}$ellipsisText"
        } else text
    }

    fun getNumberFormat(number: Long): String = NumberFormat.getInstance().format(number)

    fun getForegroundSpanString(
        string: String,
        color: Int,
        startIndex: Int = 0,
        endIndex: Int = string.length
    ): CharSequence {
        return if (isCorrectRange(string, startIndex, endIndex)) {
            SpannableStringBuilder(string).apply {
                setSpan(ForegroundColorSpan(color), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        } else string
    }

    fun getTypefaceSpanString(
        context: Context,
        string: CharSequence,
        @FontRes fontFamilyString: Int,
        startIndex: Int = 0,
        endIndex: Int = string.length
    ): CharSequence {
        if (!isCorrectRange(string, startIndex, endIndex)) return string

        val typeface = ResourcesCompat.getFont(context, fontFamilyString)

        val typeFaceSpan = object : MetricAffectingSpan() {
            override fun updateDrawState(paint: TextPaint) {
                paint.typeface = typeface
            }

            override fun updateMeasureState(paint: TextPaint) {
                paint.typeface = typeface
            }
        }

        return SpannableString(string).apply {
            setSpan(typeFaceSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    fun getStringWithClickableSpan(
        string: CharSequence,
        linkText: String,
        linkColor: Int,
        needUnderLine: Boolean = false,
        callback: () -> Unit = {}
    ): SpannableString {
        val spannableString = SpannableString(string)

        val clickSpan = object : ClickableSpan() {

            override fun onClick(widget: View) {
                callback()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = linkColor
                ds.linkColor = linkColor
                ds.isUnderlineText = needUnderLine
                ds.isFakeBoldText = true
            }
        }
        val index = spannableString.indexOf(linkText)
        val size = linkText.count()
        spannableString.setSpan(clickSpan, index, index + size, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }

    fun getHtmlText(text: String) = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)

    private fun isCorrectRange(string: CharSequence, start: Int, end: Int): Boolean {
        return when {
            end < start -> false
            start > string.length || end > string.length -> false
            start < 0 || end < 0 -> false
            else -> true
        }
    }

}