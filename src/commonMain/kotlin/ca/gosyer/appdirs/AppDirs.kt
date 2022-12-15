package ca.gosyer.appdirs


interface AppDirs {
    fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return getUserDataDir(appName, appVersion, appAuthor, false)
    }

    fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String

    fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return getUserConfigDir(appName, appVersion, appAuthor, false)
    }

    fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String

    fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String

    fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return getSiteDataDir(appName, appVersion, appAuthor, false)
    }

    fun getSiteDataDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, multiPath: Boolean
    ): String

    fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return getSiteConfigDir(appName, appVersion, appAuthor, false)
    }

    fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?, multiPath: Boolean
    ): String

    fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String

    fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String
}
