package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs
import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.UnixAppDirs
import ca.gosyer.appdirs.impl.UnixJvmEnvResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs
import node.process.Platform
import node.process.process

actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String,
): AppDirs {
    val os = process.platform
    return if (os == Platform.darwin) {
        MacOSXAppDirs(appName, appAuthor, *extra)
    } else if (os == Platform.win32) {
        WindowsAppDirs(appName, appAuthor, *extra, folderResolver = ShellFolderResolver())
    } else {
        // Assume other *nix.
        UnixAppDirs(appName, appAuthor, *extra, envResolver = UnixJvmEnvResolver())
    }
}
