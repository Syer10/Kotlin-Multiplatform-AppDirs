package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs
import ca.gosyer.appdirs.AppDirsConfig
import platform.Foundation.NSApplicationSupportDirectory
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSSearchPathDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask


class IosAppDirs(appDirsConfig: AppDirsConfig) : AppDirs {
    private val extras = appDirsConfig.extras.joinToString(pathSeparator())

    override fun getUserDataDir(roaming: Boolean): String {
        return getDirectory(NSDocumentDirectory, "app_data", extras = extras) {
            "Application documents directory not exist!"
        }
    }

    override fun getUserCacheDir(): String {
        return getDirectory(NSCachesDirectory, extras = extras) {
            "Application cache directory not exist!"
        }
    }

    override fun getUserConfigDir(roaming: Boolean): String {
        return getDirectory(NSApplicationSupportDirectory, "app_config", extras = extras) {
            "Application Support directory not exist!"
        }
    }

    override fun getUserLogDir(): String {
        return getDirectory(NSCachesDirectory, child = "app_logs", extras = extras) {
            "Application Support directory not exist!"
        }
    }

    override fun getSiteDataDir(multiPath: Boolean): String {
        return getDirectory(NSDocumentDirectory, "data", extras = extras) {
            "Application documents directory not exist!"
        }
    }

    override fun getSiteConfigDir(multiPath: Boolean): String {
        return getDirectory(NSDocumentDirectory, "config", extras = extras) {
            "Application documents directory not exist!"
        }
    }

    override fun getSharedDir(): String {
        return getDirectory(NSDocumentDirectory, extras = extras) {
            "Application documents directory not exist!"
        }
    }

    private fun getDirectory(
        dirType: NSSearchPathDirectory,
        child: String = "",
        extras: String,
        errorMessage: () -> String
    ): String {
        val paths = NSSearchPathForDirectoriesInDomains(dirType, NSUserDomainMask, true)
        val path = paths.firstOrNull() as? String ?: error(errorMessage())
        return buildPath(path, child, extras)
    }
}
