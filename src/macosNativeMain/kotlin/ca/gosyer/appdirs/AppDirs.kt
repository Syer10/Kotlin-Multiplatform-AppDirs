package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs

actual fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs {
    val config = AppDirsConfig().apply(config)
    return MacOSXAppDirs(config)
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

@Deprecated("Use AppDirs DSL instead.")
fun AppDirs(
    appName: String?,
    appAuthor: String? = null,
    extra: List<String> = emptyList(),
): AppDirs {
    return AppDirs {
        this.appName = appName
        this.appAuthor = appAuthor
        this.extras = extra.toTypedArray()
    }
}