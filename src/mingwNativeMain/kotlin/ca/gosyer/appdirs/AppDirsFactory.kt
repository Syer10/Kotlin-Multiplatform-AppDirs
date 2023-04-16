package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs

actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String,
) : AppDirs {
    return WindowsAppDirs(appName, appAuthor, *extra, folderResolver = ShellFolderResolver())
}