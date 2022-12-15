package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

class WindowsAppDirs(private val folderResolver: WindowsFolderResolver) : AppDirs {
    enum class FolderId {
        APPDATA, LOCAL_APPDATA, COMMON_APPDATA
    }

    override fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        val dir = if (roaming) appData else localAppData
        return buildPath(dir, appAuthor, appName, appVersion)
    }

    override fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        return getUserDataDir(appName, appVersion, appAuthor, roaming)
    }

    override fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(
            localAppData, appAuthor, appName, "\\Cache", appVersion
        )
    }

    override fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        return buildPath(commonAppData, appAuthor, appName, appVersion)
    }

    override fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        return getSiteDataDir(appName, appVersion, appAuthor, multiPath)
    }

    override fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(
            localAppData, appAuthor, appName, "\\Logs", appVersion
        )
    }

    override fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(commonAppData, appAuthor, appName, appVersion)
    }

    private val appData: String
        get() = folderResolver[FolderId.APPDATA]
    private val localAppData: String
        get() = folderResolver[FolderId.LOCAL_APPDATA]
    private val commonAppData: String
        get() = folderResolver[FolderId.COMMON_APPDATA]
}