package com.bebye.base.extension

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.PermissionChecker

/**
 * Created by mkwon on 12/12/2020.
 */
enum class PermissionType(val permissions: Array<String>) {
    GALLERY(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)),
    CAMERA(arrayOf(Manifest.permission.CAMERA)),
    RECORD_AUDIO(arrayOf(Manifest.permission.RECORD_AUDIO))
}

private val PERMISSION_GALLERY_Q = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

fun Context.checkGalleryPermission() = checkPermissions(getGalleryPermissions())

fun Context.checkCameraPermission(): Boolean {
    return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)
            && checkPermissions(PermissionType.CAMERA.permissions)
}

fun Context.checkRecordAudioPermission() = checkPermissions(PermissionType.RECORD_AUDIO.permissions)

fun Context.checkPermissions(permissions: Array<String>): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        for (permission in permissions) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
                && permission == Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) {
                continue
            }
            when (PermissionChecker.checkSelfPermission(this, permission)) {
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