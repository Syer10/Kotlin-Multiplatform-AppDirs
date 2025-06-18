package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs
import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.UnixAppDirs
import ca.gosyer.appdirs.impl.UnixJsEnvResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs
import node.process.Platform
import node.process.process

actual fun AppDirs(config: AppDirsConfig.() -> Unit): AppDirs {
    val appDirsConfig = AppDirsConfig().apply(config)
    val os = process.platform
    return if (os == Platform.darwin) {
        MacOSXAppDirs(appDirsConfig)
    } else if (os == Platform.win32) {
        WindowsAppDirs(appDirsConfig, folderResolver = ShellFolderResolver())
    } else {
        // Assume other *nix.
        UnixAppDirs(appDirsConfig, envResolver = UnixJsEnvResolver())
    }
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
