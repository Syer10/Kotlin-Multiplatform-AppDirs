package ca.gosyer.appdirs


interface AppDirs {

    fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean = false
    ): String

    fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean = false
    ): String

    fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String

    fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean = false
    ): String

    fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean = false
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
