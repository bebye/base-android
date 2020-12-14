package com.bebye.base.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.PermissionChecker

/**
 * Created by mkwon on 12/12/2020.
 */
object PermissionUtil {

    enum class PermissionType(val permissions: Array<String>) {
        GALLERY(getGalleryPermissions()),
        CAMERA(arrayOf(Manifest.permission.CAMERA)),
        RECORD_AUDIO(arrayOf(Manifest.permission.RECORD_AUDIO))
    }

    private val PERMISSION_GALLERY_Q = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    fun checkGalleryPermission(context: Context) = checkPermissions(context, getGalleryPermissions())

    fun checkCameraPermission(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)
                && checkPermissions(context, PermissionType.CAMERA.permissions)
    }

    fun checkRecordAudioPermission(context: Context) =
        checkPermissions(context, PermissionType.RECORD_AUDIO.permissions)

    fun checkPermissions(context: Context, permissions: Array<String>): Boolean {
        if (checkPermissionAvailable()) {
            for (permission in permissions) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
                    && permission == Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) {
                    continue
                }
                when (PermissionChecker.checkSelfPermission(context, permission)) {
                    PermissionChecker.PERMISSION_GRANTED -> return true
                    PermissionChecker.PERMISSION_DENIED -> return false
                    PermissionChecker.PERMISSION_DENIED_APP_OP -> return false
                }
            }
        }
        return true
    }

    private fun getGalleryPermissions() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        PERMISSION_GALLERY_Q
    } else PermissionType.GALLERY.permissions

    private fun checkPermissionAvailable() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

}