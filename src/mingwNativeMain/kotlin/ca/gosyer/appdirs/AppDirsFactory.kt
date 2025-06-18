package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs

actual fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs {
    val config = AppDirsConfig().apply(config)
    return WindowsAppDirs(config, folderResolver = ShellFolderResolver())
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