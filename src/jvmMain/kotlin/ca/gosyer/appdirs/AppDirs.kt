package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs
import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.UnixAppDirs
import ca.gosyer.appdirs.impl.UnixJvmEnvResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs

actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String,
): AppDirs {
    val os = System.getProperty("os.name").lowercase()
    return if (os.startsWith("mac os x")) {
        MacOSXAppDirs(appName, appAuthor, *extra)
    } else if (os.startsWith("windows")) {
        WindowsAppDirs(appName, appAuthor, *extra, folderResolver = ShellFolderResolver())
    } else {
        // Assume other *nix.
        UnixAppDirs(appName, appAuthor, *extra, envResolver = UnixJvmEnvResolver())
    }
}
