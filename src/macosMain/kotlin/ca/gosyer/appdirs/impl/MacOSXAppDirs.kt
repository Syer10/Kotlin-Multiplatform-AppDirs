package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

class MacOSXAppDirs : AppDirs {
    override fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        return buildPath(
            home(),
            "/Library/Application Support",
            appName,
            appVersion
        )
    }

    override fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        return buildPath(home(), "/Library/Preferences", appName, appVersion)
    }

    override fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(home(), "/Library/Caches", appName, appVersion)
    }

    override fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Application Support", appName, appVersion)
    }

    override fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Preferences", appName, appVersion)
    }

    override fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(home(), "/Library/Logs", appName, appVersion)
    }

    override fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(
            "/Users/Shared/Library/Application Support", appName,
            appVersion
        )
    }
}