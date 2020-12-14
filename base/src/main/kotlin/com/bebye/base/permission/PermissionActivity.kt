package com.bebye.base.permission

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bebye.logger.log.Logger

/**
 * Created by mkwon on 12/12/2020.
 */
typealias OnPermissionCallback = (isGranted: Boolean) -> Unit

abstract class PermissionActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {

    private var onPermissionCallback: OnPermissionCallback? = null

    protected fun checkPermissions(
        permissionType: PermissionUtil.PermissionType, onPermissionCallback: OnPermissionCallback
    ) {
        checkPermissions(permissionType.permissions, onPermissionCallback)
    }

    protected fun checkPermissions(permissions: Array<String>, onPermissionCallback: OnPermissionCallback) {
        when {
            PermissionUtil.checkPermissions(this, permissions) -> onPermissionCallback(true)
            else -> requestPermission(permissions, onPermissionCallback)
        }
    }

    private fun requestPermission(permissions: Array<String>, onPermissionCallback: OnPermissionCallback) {
        this.onPermissionCallback = onPermissionCallback
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            Logger.d("registerForActivityResult : $it")
            for (permission in permissions) {
                if (it.containsKey(permission) && it[permission] == false) {
                    reRequestPermission(permission, onPermissionCallback)
                    return@registerForActivityResult
                }
            }
            onPermissionCallback(true)
        }.launch(permissions)
    }

    private fun reRequestPermission(permission: String, onPermissionCallback: OnPermissionCallback) {
        if (shouldShowRequestPermissionRationale(permission)) {
            // TODO: show like toast
            Logger.d("shouldShowRequestPermissionRationale: true - $permission")
            requestPermissionLauncher(permission, onPermissionCallback)
        } else {
            // TODO: show like toast
            Logger.d("shouldShowRequestPermissionRationale: false - $permission")
            requestPermissionLauncher(permission, onPermissionCallback)
        }
    }

    private fun requestPermissionLauncher(permission: String, onPermissionCallback: OnPermissionCallback) {
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            Logger.d("$permission = $it")
            onPermissionCallback(it)
        }.launch(permission)
    }

}