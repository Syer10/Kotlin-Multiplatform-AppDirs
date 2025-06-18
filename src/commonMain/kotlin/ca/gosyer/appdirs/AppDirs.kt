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

@DslMarker
annotation class AppDirsDsl

@AppDirsDsl
class AppDirsConfig {
    @AppDirsDsl
    var appName: String? = null
    @AppDirsDsl
    var appAuthor: String? = null
    @AppDirsDsl
    var extras: Array<out String> = emptyArray()

    @AppDirsDsl
    fun extras(vararg extra: String) {
        this.extras = extra
    }

    @AppDirsDsl
    val macOS = MacOS()
    @AppDirsDsl
    class MacOS {
        var useSpaceBetweenAuthorAndApp = true
        var useLegacyConfigDir = false
    }
    @AppDirsDsl
    fun macOs(config: MacOS.() -> Unit) {
        macOS.config()
    }

    @AppDirsDsl
    val linux = Linux()
    @AppDirsDsl
    class Linux {
        var useLegacyLogsDir = false
    }
    @AppDirsDsl
    fun linux(config: Linux.() -> Unit) {
        linux.config()
    }

    @AppDirsDsl
    val windows = Windows()
    @AppDirsDsl
    class Windows
    @AppDirsDsl
    fun windows(config: Windows.() -> Unit) {
        windows.config()
    }

    @AppDirsDsl
    val android = Android()
    @AppDirsDsl
    class Android
    @AppDirsDsl
    fun android(config: Android.() -> Unit) {
        android.config()
    }
}

expect fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs

@Deprecated("Use AppDirs DSL instead.")
expect fun AppDirs(
    appName: String?,
    appAuthor: String? = null,
    vararg extra: String
): AppDirs