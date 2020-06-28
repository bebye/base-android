package com.bebye.base

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri

/**
 * Created by mkwon on 28/06/2020.
 */
class BaseInitProvider : ContentProvider() {

    override fun attachInfo(context: Context?, info: ProviderInfo?) {
        super.attachInfo(context, info)
    }

    override fun onCreate(): Boolean {
        appContext = context as Application
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ) : Cursor? = null

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ) = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0

    override fun getType(uri: Uri) : String? = null

}