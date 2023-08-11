package com.android.carbrew.util

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import com.android.carbrew.CarbrewApplication
import com.android.carbrew.extension.logW
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import java.util.UUID

object GlobalUtil {
    private var TAG = "GlobalUtil"

    val appPackage: String
        get() = CarbrewApplication.context.packageName

    fun getString(resId: Int): String = CarbrewApplication.context.resources.getString(resId)

    val appVersionName: String
        get() = CarbrewApplication.context.packageManager.getPackageInfo(
            appPackage, 0
        ).versionName

    /**
     * 获取当前应用程序的版本号。
     * @return 当前应用程序的版本号。
     */
    val appVersionCode: Long
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            CarbrewApplication.context.packageManager.getPackageInfo(
                appPackage, 0
            ).longVersionCode
        } else {
            CarbrewApplication.context.packageManager.getPackageInfo(
                appPackage, 0
            ).versionCode.toLong()
        }

    @SuppressLint("HardwareIds")
    fun getDeviceSerial(): String {
        if (deviceSerial == null) {
            var deviceId: String? = null
            val appChannel = getApplicationMetaData("APP_CHANNEL")
            if ("google" != appChannel || "samsung" != appChannel) {
                try {
                    deviceId = Settings.Secure.getString(
                        CarbrewApplication.context.contentResolver, Settings.Secure.ANDROID_ID
                    )
                } catch (e: Exception) {
                    logW(TAG, "get android_id with error", e)
                }
                if (!TextUtils.isEmpty(deviceId) && deviceId!!.length < 255) {
                    deviceSerial = deviceId
                    return deviceSerial.toString()
                }
            }
            var uuid = DataStoreUtils.readStringData("uuid", "")
            if (!TextUtils.isEmpty(uuid)) {
                deviceSerial = uuid
                return deviceSerial.toString()
            }
            uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.getDefault())
            CoroutineScope(Dispatchers.IO).launch { DataStoreUtils.saveStringData("uuid", uuid) }
            deviceSerial = uuid
            return deviceSerial.toString()
        } else {
            return deviceSerial.toString()
        }
    }

    val carbrewVersionName: String
        get() = "0.1.0"

    val carbrewVersionCode: Long
        get() = 100000

    fun getApplicationMetaData(key: String): String? {
        var applicationInfo: ApplicationInfo? = null
        try {
            applicationInfo = CarbrewApplication.context.packageManager.getApplicationInfo(
                appPackage, PackageManager.GET_META_DATA
            )
        } catch (e: PackageManager.NameNotFoundException) {
            logW(TAG, e.message, e)
        }
        if (applicationInfo == null) return ""
        return applicationInfo.metaData.getString(key)
    }


    val deviceModel: String
        get() {
            var deviceModel = Build.MODEL
            if (TextUtils.isEmpty(deviceModel)) {
                deviceModel = "unknown"
            }
            return deviceModel
        }

    /**
     * 获取设备的品牌，如果无法获取到，则返回Unknown。
     * @return 设备品牌，全部转换为小写格式。
     */
    val deviceBrand: String
        get() {
            var deviceBrand = Build.BRAND
            if (TextUtils.isEmpty(deviceBrand)) {
                deviceBrand = "unknown"
            }
            return deviceBrand.toLowerCase(Locale.getDefault())
        }

    private var deviceSerial: String? = null

}