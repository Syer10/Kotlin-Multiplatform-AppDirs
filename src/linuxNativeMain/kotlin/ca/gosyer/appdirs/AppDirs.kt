package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.LinuxEnvResolver
import ca.gosyer.appdirs.impl.UnixAppDirs

actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String,
): AppDirs {
    return UnixAppDirs(appName, appAuthor, *extra, envResolver = LinuxEnvResolver())
}