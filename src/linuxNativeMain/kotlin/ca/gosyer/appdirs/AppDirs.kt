package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.LinuxEnvResolver
import ca.gosyer.appdirs.impl.UnixAppDirs

actual fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs {
    val config = AppDirsConfig().apply(config)
    return UnixAppDirs(config, envResolver = LinuxEnvResolver())
}

@Deprecated("Use AppDirs DSL instead.")
actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String,
): AppDirs {
    return AppDirs {
        this.appName = appName
        this.appAuthor = appAuthor
        this.extras = extra
    }
}