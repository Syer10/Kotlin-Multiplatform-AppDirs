package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs
import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.UnixAppDirs
import ca.gosyer.appdirs.impl.UnixJvmEnvResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs

actual fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs {
    val appDirsConfig = AppDirsConfig().apply(config)
    val os = System.getProperty("os.name").lowercase()
    return if (os.startsWith("mac os x")) {
        MacOSXAppDirs(appDirsConfig)
    } else if (os.startsWith("windows")) {
        WindowsAppDirs(appDirsConfig, folderResolver = ShellFolderResolver())
    } else {
        // Assume other *nix.
        UnixAppDirs(appDirsConfig, envResolver = UnixJvmEnvResolver())
    }
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
