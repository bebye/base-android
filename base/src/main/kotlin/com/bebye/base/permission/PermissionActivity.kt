package com.bebye.base.permission

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bebye.base.extension.PermissionType
import com.bebye.base.extension.checkPermissions

/**
 * Created by mkwon on 12/12/2020.
 */
typealias OnPermissionCallback = (isGranted: Boolean) -> Unit

abstract class PermissionActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {

    private var onPermissionCallback: OnPermissionCallback? = null

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            onPermissionCallback?.let { it(isGranted) }
        }

    protected fun checkPermissions(permissionType: PermissionType, onPermissionCallback: OnPermissionCallback) {
        checkPermissions(permissionType.permissions, onPermissionCallback)
    }

    protected fun checkPermissions(permissions: Array<String>, onPermissionCallback: OnPermissionCallback) {
        when {
            checkPermissions(permissions) -> onPermissionCallback(true)
            else -> requestPermission(permissions, onPermissionCallback)
        }
    }

    private fun requestPermission(permissions: Array<String>, onPermissionCallback: OnPermissionCallback) {
        this.onPermissionCallback = onPermissionCallback
        for (permission in permissions) {
            if (shouldShowRequestPermissionRationale(permission)) {
                // TODO: show like toast
                requestPermissionLauncher.launch(permission)
            } else {
                // TODO: show like toast
                requestPermissionLauncher.launch(permission)
            }
        }
    }

}