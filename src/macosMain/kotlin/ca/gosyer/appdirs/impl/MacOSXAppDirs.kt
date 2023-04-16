package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

class MacOSXAppDirs(
    private val appName: String?,
    private val appAuthor: String? = null,
    vararg extra: String,
) : AppDirs {
    private val extras = extra

    override fun getUserDataDir(
        roaming: Boolean
    ): String {
        return buildPath(
            home(),
            "/Library/Application Support",
            getAppName(),
            *extras
        )
    }

    override fun getUserConfigDir(
        roaming: Boolean
    ): String {
        return buildPath(home(), "/Library/Preferences", getAppName(), *extras)
    }

    override fun getUserCacheDir(): String {
        return buildPath(home(), "/Library/Caches", getAppName(), *extras)
    }

    override fun getSiteDataDir(
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Application Support", getAppName(), *extras)
    }

    override fun getSiteConfigDir(
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Preferences", getAppName(), *extras)
    }

    override fun getUserLogDir(): String {
        return buildPath(home(), "/Library/Logs", getAppName(), *extras)
    }

    override fun getSharedDir(): String {
        return buildPath(
            "/Users/Shared/Library/Application Support",
            getAppName(),
            *extras
        )
    }

    private fun getAppName() = if (appAuthor != null && appName != null) {
        "$appAuthor $appName"
    } else appName ?: appAuthor
}