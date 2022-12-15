package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs
import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.UnixAppDirs
import ca.gosyer.appdirs.impl.WindowsAppDirs

fun AppDirs(): AppDirs {
    val os = System.getProperty("os.name").lowercase()
    return if (os.startsWith("mac os x")) {
        MacOSXAppDirs()
    } else if (os.startsWith("windows")) {
        WindowsAppDirs(ShellFolderResolver())
    } else {
        // Assume other *nix.
        UnixAppDirs()
    }
}
