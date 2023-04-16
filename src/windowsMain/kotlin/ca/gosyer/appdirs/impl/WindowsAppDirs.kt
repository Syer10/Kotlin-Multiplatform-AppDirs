package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

class WindowsAppDirs(
    private val appName: String?,
    private val appAuthor: String? = null,
    vararg extra: String,
    private val folderResolver: WindowsFolderResolver
) : AppDirs {
    private val extras = extra

    enum class FolderId {
        APPDATA, LOCAL_APPDATA, COMMON_APPDATA
    }

    override fun getUserDataDir(
        roaming: Boolean
    ): String {
        val dir = if (roaming) appData else localAppData
        return buildPath(dir, appAuthor, appName, *extras)
    }

    override fun getUserConfigDir(
        roaming: Boolean
    ): String {
        return getUserDataDir(roaming)
    }

    override fun getUserCacheDir(): String {
        return buildPath(
            localAppData, appAuthor, appName, "\\Cache", *extras
        )
    }

    override fun getSiteDataDir(
        multiPath: Boolean
    ): String {
        return buildPath(commonAppData, appAuthor, appName, *extras)
    }

    override fun getSiteConfigDir(
        multiPath: Boolean
    ): String {
        return getSiteDataDir(multiPath)
    }

    override fun getUserLogDir(): String {
        return buildPath(
            localAppData, appAuthor, appName, "\\Logs", *extras
        )
    }

    override fun getSharedDir(): String {
        return buildPath(commonAppData, appAuthor, appName, *extras)
    }

    private val appData: String
        get() = folderResolver[FolderId.APPDATA]
    private val localAppData: String
        get() = folderResolver[FolderId.LOCAL_APPDATA]
    private val commonAppData: String
        get() = folderResolver[FolderId.COMMON_APPDATA]
}