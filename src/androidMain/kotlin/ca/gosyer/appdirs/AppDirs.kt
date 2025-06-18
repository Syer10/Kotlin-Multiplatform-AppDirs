package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.AndroidAppDirs
import ca.gosyer.appdirs.impl.ContextRef

actual fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs {
    val config = AppDirsConfig().apply(config)
    return AndroidAppDirs(ContextRef, config)
}

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
