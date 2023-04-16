package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs

actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String,
): AppDirs {
    return MacOSXAppDirs(appName, appAuthor, *extra)
}

fun AppDirs(
    appName: String?,
    appAuthor: String? = null,
    extra: List<String> = emptyList(),
): AppDirs {
    return MacOSXAppDirs(appName, appAuthor, *extra.toTypedArray())
}