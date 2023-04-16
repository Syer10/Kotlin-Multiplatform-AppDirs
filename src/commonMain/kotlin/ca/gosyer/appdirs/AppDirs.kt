package ca.gosyer.appdirs


interface AppDirs {

    fun getUserDataDir(
        roaming: Boolean = false
    ): String

    fun getUserConfigDir(
        roaming: Boolean = false
    ): String

    fun getUserCacheDir(): String

    fun getSiteDataDir(
        multiPath: Boolean = false
    ): String

    fun getSiteConfigDir(
        multiPath: Boolean = false
    ): String

    fun getUserLogDir(): String

    fun getSharedDir(): String
}

expect fun AppDirs(
    appName: String?,
    appAuthor: String? = null,
    vararg extra: String
): AppDirs